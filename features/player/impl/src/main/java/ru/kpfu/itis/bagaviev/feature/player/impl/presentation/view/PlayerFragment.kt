package ru.kpfu.itis.bagaviev.feature.player.impl.presentation.view

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import coil.ImageLoader
import coil.load
import coil.memory.MemoryCache
import coil.request.ImageRequest
import jp.wasabeef.blurry.Blurry
import ru.kpfu.itis.bagaviev.common.base.BaseFragment
import ru.kpfu.itis.bagaviev.common.util.extensions.blur
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.bagaviev.common.util.listeners.setOnSeekBarChangeListener
import ru.kpfu.itis.bagaviev.feature.player.impl.R
import ru.kpfu.itis.bagaviev.feature.player.impl.databinding.FragmentPlayerBinding
import ru.kpfu.itis.bagaviev.feature.player.impl.di.PlayerComponentHolder
import ru.kpfu.itis.bagaviev.feature.player.impl.presentation.states.PlayerUiState
import ru.kpfu.itis.bagaviev.feature.player.impl.presentation.view.custom.PlayPauseButton
import javax.inject.Inject

class PlayerFragment : BaseFragment(R.layout.fragment_player) {

    @Inject lateinit var exoPlayer: ExoPlayer

    private lateinit var viewModelFactory: PlayerViewModel.Companion.Factory

    private var viewBinding: FragmentPlayerBinding? = null

    private val viewModel: PlayerViewModel by activityViewModels {
        viewModelFactory
    }

    private fun observeUiState(state: PlayerUiState) {
        viewBinding?.apply {
            state.apply {
                tvTitle.text = title
                tvAuthors.text = authors

                btnPlayOrPause.state = if (isPlaying) {
                    exoPlayer.play()
                    PlayPauseButton.ButtonState.PLAY
                }
                else {
                    exoPlayer.pause()
                    PlayPauseButton.ButtonState.PAUSE
                }

                ivCover.load(
                    data = coverUri,
                    builder = {
                        allowHardware(false)
                        listener { _, result ->
                            val drawable = result.drawable
                            ivCover.setImageDrawable(drawable)
                            ivCoverBlurred.setImageDrawable(drawable)
                            ivCoverBlurred.blur(
                                radius = ru.kpfu.itis.bagaviev.theme.R.integer.blur_radius,
                                sampling = ru.kpfu.itis.bagaviev.theme.R.integer.blur_sampling
                            )
                        }
                    }
                )
            }
        }
    }

    private fun observeVideoFileUriState(videoFileUri: Uri?) {
        videoFileUri?.also {
            exoPlayer.setMediaItem(MediaItem.fromUri(videoFileUri))
            exoPlayer.play()
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
        viewBinding?.apply {
            pvVideo.player = exoPlayer
            exoPlayer.volume = 0f
            exoPlayer.prepare()
        }
        with (viewModel) {
            uiState.observe(viewLifecycleOwner, ::observeUiState)
            currentProgressState.observe(viewLifecycleOwner, ::observeCurrentPlayingProgressState)
            currentProgressTimeState.observe(viewLifecycleOwner, ::observeCurrentPlayingTimeState)
            currentPlayingVideoState.observe(viewLifecycleOwner, ::observeVideoFileUriState)
        }
        initListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        exoPlayer.release()
        PlayerComponentHolder.releaseComponent()
    }
}