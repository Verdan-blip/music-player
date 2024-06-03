package ru.kpfu.itis.bagaviev.navigation.presentation.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import coil.load
import ru.kpfu.itis.bagaviev.R
import ru.kpfu.itis.bagaviev.common.base.music.BaseMusicFragment
import ru.kpfu.itis.bagaviev.common.base.music.BaseMusicViewModel
import ru.kpfu.itis.bagaviev.common.util.extensions.foldNullability
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.bagaviev.common.util.listeners.setOnSeekBarChangeListener
import ru.kpfu.itis.bagaviev.databinding.FragmentMainBinding
import ru.kpfu.itis.bagaviev.navigation.Navigator
import ru.kpfu.itis.bagaviev.presentation.util.appComponent
import javax.inject.Inject

class MainFragment : BaseMusicFragment(R.layout.fragment_main) {

    @Inject lateinit var navigator: Navigator

    private var viewBinding: FragmentMainBinding? = null

    private var navController: NavController? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        appComponent.inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentMainBinding.inflate(
            inflater, container, false
        )
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with (musicViewModel) {
            isPlayingState.observe(viewLifecycleOwner, ::observeIsPlaying)
            playingProgressState.observe(viewLifecycleOwner, ::observePlayingPosition)
            currentMusicData.observe(viewLifecycleOwner, ::observeCurrentMusicData)
            formattedPlayingTimeState.observe(viewLifecycleOwner, ::observeFormattedPlayingTime)
        }

        viewBinding?.layoutPlayingTrack?.apply {
            sbPlayingTrackProgress.setOnSeekBarChangeListener(
                onStopTrackingTouch = { seekBar ->
                    seekBar?.apply { musicViewModel.onSeekTo(progress) }
                },
                onStartTrackingTouch = { seekBar ->
                    seekBar?.apply { musicViewModel.onSeeking(progress) }
                }
            )
            ibPlayingStatus.setOnClickListener {
                musicViewModel.onPlayPause()
            }
            root.setOnClickListener {
                navigator.navigateToPlayer()
            }
        }

        val navHostFragment = childFragmentManager.findFragmentById(R.id.fv_main)
                as NavHostFragment

        navController = navHostFragment.navController

        navController?.also { controller ->
            navigator.attachNavController(controller)
        }

        setupBottomNavigationView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        navController?.also { controller ->
            navigator.detachNavController(controller)
        }
    }

    private fun observeCurrentMusicData(musicData: BaseMusicViewModel.MusicData?) {
        viewBinding?.layoutPlayingTrack?.apply {
            musicData?.apply {
                musicData.foldNullability(
                    onNotNull = {
                        root.isVisible = true
                        tvPlayingTrackTitle.text = title
                        tvPlayingTrackAuthors.text = authors.joinToString(separator = "& ")
                        ivPlayingTrackCover.load(coverUri)
                    },
                    onNull = {
                        root.isVisible = false
                    }
                )
            }
        }
    }

    private fun observePlayingPosition(position: Int) {
        viewBinding?.layoutPlayingTrack?.apply {
            sbPlayingTrackProgress.progress = position
        }
    }

    private fun observeIsPlaying(isPlaying: Boolean){
        viewBinding?.layoutPlayingTrack?.apply {
            ibPlayingStatus.setImageResource(
                if (isPlaying)
                    ru.kpfu.itis.bagaviev.theme.R.drawable.item_playing
                else
                    ru.kpfu.itis.bagaviev.theme.R.drawable.item_paused
            )
        }
    }

    private fun observeFormattedPlayingTime(playingTime: String) {
        viewBinding?.layoutPlayingTrack?.apply {
            tvPlayingTime.text = playingTime
        }
    }

    private fun setupBottomNavigationView() {
        viewBinding?.apply {
            bnvMain.setOnItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.feedFragment -> navController?.navigate(R.id.feedFragment)
                    R.id.searchFragment -> navController?.navigate(R.id.searchFragment)
                    R.id.profileFragment -> navController?.navigate(R.id.profileFragment)
                    R.id.uploadFragment -> navController?.navigate(R.id.uploadFragment)
                }
                true
            }
        }
    }
}