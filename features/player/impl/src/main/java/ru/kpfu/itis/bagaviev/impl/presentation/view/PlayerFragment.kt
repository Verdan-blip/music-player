package ru.kpfu.itis.bagaviev.impl.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.ImageLoader
import coil.request.ImageRequest
import jp.wasabeef.blurry.Blurry
import ru.kpfu.itis.bagaviev.impl.R
import ru.kpfu.itis.bagaviev.impl.databinding.FragmentPlayerBinding
import ru.kpfu.itis.bagaviev.impl.di.PlayerComponentHolder
import ru.kpfu.itis.bagaviev.impl.presentation.entities.MusicItemModel
import ru.kpfu.itis.bagaviev.impl.presentation.states.PlayPauseButtonState
import ru.kpfu.itis.bagaviev.impl.presentation.view.custom.PlayPauseButton
import ru.kpfu.itis.common.util.extensions.observe
import ru.kpfu.itis.common.util.listeners.setOnSeekBarChangeListener

class PlayerFragment : Fragment(R.layout.fragment_player) {

    private var viewBinding: FragmentPlayerBinding? = null

    private val viewModel by lazy {
        with (PlayerComponentHolder) {
            provideContext(requireContext().applicationContext)
            buildComponent()
            bind(requireActivity().lifecycle)
            requireComponent()
        }.viewModelFactory.create(PlayerViewModel::class.java)
    }

    private fun observePlayingTimeState(formattedTime: String) {
        viewBinding?.apply {
            tvPlayingTime.text = formattedTime
        }
    }

    private fun observePlayingTimeProgressState(progress: Int) {
        viewBinding?.apply {
            sbPlayingProgress.progress = progress
        }
    }

    private fun observePlayPauseButton(playPauseButtonState: PlayPauseButtonState) {
        viewBinding?.apply {
            when (playPauseButtonState) {
                is PlayPauseButtonState.Playing -> {
                    btnPlayOrPause.state = PlayPauseButton.ButtonState.PLAY
                }
                is PlayPauseButtonState.Paused -> {
                    btnPlayOrPause.state = PlayPauseButton.ButtonState.PAUSE
                }
            }
        }
    }

    private fun observeMusicItemState(musicItemModel: MusicItemModel?) {
        viewBinding?.apply {
            musicItemModel?.apply {
                tvAuthors.text = authors.joinToString()
                tvTitle.text = title
                val request = ImageRequest.Builder(requireContext())
                    .data(posterUri)
                    .lifecycle(viewLifecycleOwner)
                    .listener(
                        onSuccess = { req, result ->
                            ivCover.setImageDrawable(result.drawable)
                            ivCoverBlurred.setImageDrawable(result.drawable)
                            Blurry.with(context)
                                .radius(100)
                                .sampling(20)
                                .capture(ivCover)
                                .into(ivCoverBlurred)
                        }
                    )
                    .build()
                ImageLoader.Builder(requireContext())
                    .build()
                    .enqueue(request)
            }
        }
    }

    private fun initViews() {
        viewBinding?.apply {
            btnPlayOrPause.setOnClickListener {
                viewModel.onPlayPauseButtonPress()
            }
            sbPlayingProgress.setOnSeekBarChangeListener(
                onStopTrackingTouch = { seekBar ->
                    seekBar?.apply {
                        viewModel.onReleaseSeekBarThumb(progress)
                    }
                },
                onStartTrackingTouch = { seekBar ->
                    seekBar?.apply {
                        viewModel.onHoldAndMoveSeekBarThumb(progress)
                    }
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
            playingTimeState.observe(viewLifecycleOwner, ::observePlayingTimeState)
            playingTimeProgressState.observe(viewLifecycleOwner, ::observePlayingTimeProgressState)
            playPauseButtonState.observe(viewLifecycleOwner, ::observePlayPauseButton)
            currentMusicItemState.observe(viewLifecycleOwner, ::observeMusicItemState)
        }
        initViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}