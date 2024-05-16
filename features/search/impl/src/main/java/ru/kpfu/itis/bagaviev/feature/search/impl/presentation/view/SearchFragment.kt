package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.bagaviev.feature.search.impl.R
import ru.kpfu.itis.bagaviev.feature.search.impl.databinding.FragmentSearchBinding
import ru.kpfu.itis.bagaviev.feature.search.impl.di.SearchComponentHolder
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.adapter.FoundAdapter
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.decorator.FoundItemDecorator
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.mappers.toTrackItem
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.state.SearchUiState
import ru.kpfu.itis.bagaviev.theme.recyclerview.interactor.PlaylistInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.interactor.TrackInteractor

class SearchFragment : Fragment(R.layout.fragment_search) {

    private var viewBinding: FragmentSearchBinding? = null

    private val viewModel: SearchViewModel by viewModels(::requireActivity) {
        SearchComponentHolder
            .createComponent(requireContext())
            .viewModelFactory
    }

    private val foundAdapter by lazy {
        FoundAdapter(
            context = requireContext(),
            tracksInteractor = TrackInteractor.Builder()
                .onClick(viewModel::onTrackClick)
                .onMoveHeldThumb(viewModel::onMoveHeldSeekBar)
                .onReleaseThumb(viewModel::onSeekTo)
                .build(),
            playlistsInteractor = PlaylistInteractor.Builder()
                .onClick(viewModel::onPlaylistClick)
                .build()
        )
    }

    private fun observeUiState(state: SearchUiState) {
        foundAdapter.apply {
            if (state.isPlaying) play() else pause()
            submitList(state.foundTracks.map { trackModel ->
                trackModel.toTrackItem()
            }) { state.playingMusicItem?.apply { markAsPlayable(id) } }
            submitPlaylistList(state.foundPlaylists)
        }
    }

    private fun observePlayingProgress(progress: Int) {
        foundAdapter.updatePlayingProgress(progress)
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
            rvFound.addItemDecoration(FoundItemDecorator(requireContext()))
        }
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            uiState.observe(viewLifecycleOwner, ::observeUiState)
            currentPlayingProgress.observe(viewLifecycleOwner, ::observePlayingProgress)
        }

        viewBinding?.apply {
            ibSearch.setOnClickListener {
                viewModel.onSearch(etKeywords.text.toString())
            }
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