package ru.kpfu.itis.bagaviev.feature.player.impl.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.viewModels
import coil.ImageLoader
import coil.memory.MemoryCache
import coil.request.ImageRequest
import jp.wasabeef.blurry.Blurry
import ru.kpfu.itis.bagaviev.common.base.BaseFragment
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.bagaviev.common.util.listeners.setOnSeekBarChangeListener
import ru.kpfu.itis.bagaviev.feature.player.impl.R
import ru.kpfu.itis.bagaviev.feature.player.impl.databinding.FragmentPlayerBinding
import ru.kpfu.itis.bagaviev.feature.player.impl.di.PlayerComponentHolder
import ru.kpfu.itis.bagaviev.feature.player.impl.presentation.states.PlayerUiState
import ru.kpfu.itis.bagaviev.feature.player.impl.presentation.view.custom.PlayPauseButton

class PlayerFragment : BaseFragment(R.layout.fragment_player) {

    private var viewBinding: FragmentPlayerBinding? = null

    private val viewModel: PlayerViewModel by viewModels {
        PlayerComponentHolder.createComponent(requireContext())
            .viewModelFactory
    }

    private fun observeUiState(state: PlayerUiState) {
        viewBinding?.apply {
            state.apply {
                tvTitle.text = title
                tvAuthors.text = authors

                btnPlayOrPause.state = if (isPlaying)
                    PlayPauseButton.ButtonState.PLAY
                else
                    PlayPauseButton.ButtonState.PAUSE

                requireContext().resources.apply {
                    val imageRequest = ImageRequest.Builder(requireContext())
                        .data(coverUri)
                        .allowHardware(false)
                        .listener { _, result ->
                            ivCover.setImageDrawable(result.drawable)
                            Blurry.with(context)
                                .sampling(getInteger(ru.kpfu.itis.bagaviev.theme.R.integer.blur_sampling))
                                .radius(getInteger(ru.kpfu.itis.bagaviev.theme.R.integer.blur_sampling))
                                .from(result.drawable.toBitmap())
                                .into(viewBinding?.ivCoverBlurred)
                        }
                        .build()
                    ImageLoader.Builder(requireContext())
                        .memoryCache {
                            MemoryCache.Builder(requireContext())
                                .maxSizePercent(0.25)
                                .build()
                        }
                        .build()
                        .enqueue(imageRequest)
                }
            }
        }
    }

    private fun observeCurrentPlayingTimeState(currentPlayingTime: String) {
        viewBinding?.tvPlayingTime?.text = currentPlayingTime
    }

    private fun observeCurrentPlayingProgressState(progress: Int) {
        viewBinding?.sbPlayingProgress?.progress = progress
    }


    private fun initListeners() {
        viewBinding?.apply {
            btnPlayOrPause.setOnClickListener {
                viewModel.onPlayPauseButtonPress()
            }
            sbPlayingProgress.setOnSeekBarChangeListener(
                onStopTrackingTouch = { seekBar ->
                    seekBar?.apply { viewModel.onSeekTo(progress) }
                },
                onStartTrackingTouch = { seekBar ->
                    seekBar?.apply { viewModel.onMoveHeldSeekBarThumb(progress) }
                }
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentPlayerBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with (viewModel) {
            uiState.observe(viewLifecycleOwner, ::observeUiState)
            currentProgressState.observe(viewLifecycleOwner, ::observeCurrentPlayingProgressState)
            currentProgressTimeState.observe(viewLifecycleOwner, ::observeCurrentPlayingTimeState)
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