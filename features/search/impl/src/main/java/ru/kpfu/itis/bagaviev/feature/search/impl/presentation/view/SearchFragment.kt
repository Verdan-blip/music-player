package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import ru.kpfu.itis.bagaviev.common.base.music.BaseMusicFragment
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.bagaviev.feature.search.impl.R
import ru.kpfu.itis.bagaviev.feature.search.impl.databinding.FragmentSearchBinding
import ru.kpfu.itis.bagaviev.feature.search.impl.di.SearchComponentHolder
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track.TrackDetailsModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.state.SearchUiState
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.mapper.toPlaylistRvModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.mapper.toTrackRvModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.adapter.FoundAdapter
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.decorator.FoundItemDecoration
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.util.toMusicData
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.util.toTrackRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.PlaylistInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.TrackInteractor

class SearchFragment : BaseMusicFragment(R.layout.fragment_search) {

    private var viewBinding: FragmentSearchBinding? = null

    private val viewModel: SearchViewModel by viewModels(::requireActivity) {
        SearchComponentHolder
            .createComponent(requireContext())
            .viewModelFactory
    }

    private val foundAdapter by lazy {
        FoundAdapter(
            context = requireContext(),
            trackInteractor = TrackInteractor.Builder()
                .onClick(viewModel::onTrackClick)
                .onMoveThumb(musicViewModel::onSeeking)
                .onReleaseThumb(musicViewModel::onSeekTo)
                .onPlayPauseClick(musicViewModel::onPlayPause)
                .build(),
            playlistInteractor = PlaylistInteractor.Builder()
                .onClick(viewModel::onPlaylistClick)
                .build()
        )
    }

    private fun observeUiState(state: SearchUiState) {
        foundAdapter.apply {
            state.apply {
                submitData(
                    tracks = foundTracks.map { trackModel ->
                        trackModel.toTrackRvModel()
                    },
                    playlists = foundPlaylists.map { playlistModel ->
                        playlistModel.toPlaylistRvModel()
                    }
                )
            }
        }
    }

    private fun observeSelectedTrackDetailsEvent(trackDetailsModel: TrackDetailsModel) {
        trackDetailsModel.apply {
            musicViewModel.onPlay(toMusicData())
            foundAdapter.prepareToPlay(toTrackRvModel())
        }
    }

    private fun observePlayingProgressState(progress: Int) {
        foundAdapter.updatePlayingProgress(progress)
    }

    private fun observeIsPlayingState(isPlaying: Boolean) {
        foundAdapter.updateIsPlaying(isPlaying)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSearchBinding.inflate(
            inflater, container, false
        ).apply {
            rvFound.adapter = foundAdapter
            rvFound.addItemDecoration(FoundItemDecoration(requireContext()))
        }
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            uiState.observe(viewLifecycleOwner, ::observeUiState)
            selectedTrackDetailsEvent.observe(viewLifecycleOwner, ::observeSelectedTrackDetailsEvent)
        }

        musicViewModel.apply {
            playingProgressState.observe(viewLifecycleOwner, ::observePlayingProgressState)
            isPlayingState.observe(viewLifecycleOwner, ::observeIsPlayingState)
        }

        viewBinding?.apply {
            etKeywords.addTextChangedListener(
                onTextChanged = { text, _, _, _ ->
                    viewModel.onSearchQueryChange(etKeywords.text.toString())
                }
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        SearchComponentHolder.releaseComponent()
    }
}