package ru.kpfu.itis.bagaviev.feature.profile.presentation.view.track

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.bagaviev.feature.profile.R
import ru.kpfu.itis.bagaviev.feature.profile.databinding.FragmentTracksBinding
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.user.UserProfileModel
import ru.kpfu.itis.bagaviev.feature.profile.presentation.view.ProfileViewModel
import ru.kpfu.itis.bagaviev.feature.profile.presentation.view.mapper.toTrackItem
import ru.kpfu.itis.bagaviev.theme.recyclerview.adapter.TrackAdapter
import ru.kpfu.itis.bagaviev.theme.recyclerview.decorator.TrackItemDecorator
import ru.kpfu.itis.bagaviev.theme.recyclerview.interactor.TrackInteractor

class MyTracksFragment : Fragment(R.layout.fragment_tracks) {

    private var viewBinding: FragmentTracksBinding? = null

    private val tracksAdapter by lazy {
        TrackAdapter(
            context = requireContext(),
            trackInteractor = TrackInteractor.Builder()
                .build()
        )
    }

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[ProfileViewModel::class.java]
    }

    private fun observeUserProfile(userProfileModel: UserProfileModel?) {
        userProfileModel?.apply {
            tracksAdapter.submitList(myTracks.map { myTrackModel ->
                myTrackModel.toTrackItem()
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentTracksBinding.inflate(
            inflater, container, false
        )
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding?.apply {
            rvTracks.adapter = tracksAdapter
            rvTracks.addItemDecoration(TrackItemDecorator(requireContext()))
        }

        viewModel.apply {
            userProfileState.observe(viewLifecycleOwner, ::observeUserProfile)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}