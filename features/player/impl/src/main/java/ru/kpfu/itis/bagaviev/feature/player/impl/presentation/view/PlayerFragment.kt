package ru.kpfu.itis.bagaviev.feature.player.impl.presentation.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import ru.kpfu.itis.bagaviev.common.base.BaseViewModel
import ru.kpfu.itis.bagaviev.common.base.music.BaseMusicFragment
import ru.kpfu.itis.bagaviev.common.base.music.BaseMusicViewModel
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.bagaviev.common.util.listeners.setOnSeekBarChangeListener
import ru.kpfu.itis.bagaviev.feature.player.impl.R
import ru.kpfu.itis.bagaviev.feature.player.impl.databinding.FragmentPlayerBinding
import ru.kpfu.itis.bagaviev.feature.player.impl.di.PlayerComponentHolder
import ru.kpfu.itis.bagaviev.feature.player.impl.presentation.view.custom.PlayPauseButton

class PlayerFragment : BaseMusicFragment(R.layout.fragment_player) {

    private lateinit var viewModelFactory: BaseViewModel.Companion.Factory

    private var viewBinding: FragmentPlayerBinding? = null

    private fun observeMusicDataState(musicData: BaseMusicViewModel.MusicData?) {
        viewBinding?.apply {
            musicData?.apply {
                tvTitle.text = title
                tvAuthors.text = authors.joinToString(separator = " &")
                ivCover.load(musicData.coverUri)
            }
        }
    }


    private fun observeCurrentPlayingTimeState(currentPlayingTime: String) {
        viewBinding?.tvPlayingTime?.text = currentPlayingTime
    }

    private fun observeCurrentPlayingProgressState(progress: Int) {
        viewBinding?.sbPlayingProgress?.progress = progress
    }

    private fun observeIsPlaying(isPlaying: Boolean) {
        viewBinding?.apply {
            btnPlayOrPause.state = if (isPlaying)
                PlayPauseButton.ButtonState.PLAY
            else
                PlayPauseButton.ButtonState.PAUSE
        }
    }


    private fun initListeners() {
        viewBinding?.apply {
            btnPlayOrPause.setOnClickListener {
                musicViewModel.onPlayPause()
            }
            sbPlayingProgress.setOnSeekBarChangeListener(
                onStopTrackingTouch = { seekBar ->
                    seekBar?.apply { musicViewModel.onSeekTo(progress) }
                },
                onStartTrackingTouch = { seekBar ->
                    seekBar?.apply { musicViewModel.onSeeking(progress) }
                }
            )
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val component = PlayerComponentHolder
            .createComponent(context)
        viewModelFactory = component.viewModelFactory
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentPlayerBinding.inflate(
            inflater, container, false
        )
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with (musicViewModel) {
            playingProgressState.observe(viewLifecycleOwner, ::observeCurrentPlayingProgressState)
            formattedPlayingTimeState.observe(viewLifecycleOwner, ::observeCurrentPlayingTimeState)
            isPlayingState.observe(viewLifecycleOwner, ::observeIsPlaying)
            currentMusicData.observe(viewLifecycleOwner, ::observeMusicDataState)
        }
        initListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        PlayerComponentHolder.releaseComponent()
    }
}