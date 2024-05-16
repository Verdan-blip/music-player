package ru.kpfu.itis.bagaviev.feature.profile.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.google.android.material.tabs.TabLayoutMediator
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.bagaviev.feature.profile.R
import ru.kpfu.itis.bagaviev.feature.profile.databinding.FragmentProfileBinding
import ru.kpfu.itis.bagaviev.feature.profile.di.ProfileComponentHolder
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.user.UserProfileModel
import ru.kpfu.itis.bagaviev.feature.profile.presentation.view.viewpager.TracksFragmentAdapter

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var viewBinding: FragmentProfileBinding? = null

    private val viewModel: ProfileViewModel by activityViewModels {
        ProfileComponentHolder
            .createComponent(requireContext())
            .viewModelFactory
    }

    private fun observeUserDetails(userProfile: UserProfileModel?) {
        viewBinding?.apply {
            userProfile?.apply {
                tvLogin.text = login
                tvEmail.text = email
                ivAvatar.load(userProfile.avatarUri)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.errorAlert
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentProfileBinding.inflate(
            inflater, container, false
        )
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            userProfileState.observe(viewLifecycleOwner, ::observeUserDetails)
        }

        viewBinding?.apply {
            vpTracks.adapter = TracksFragmentAdapter(requireActivity())
            TabLayoutMediator(tlTracks, vpTracks) { tab, position ->
                tab.text = when (position) {
                    0 -> "My tracks"
                    else -> "Saved tracks"
                }
            }.attach()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        ProfileComponentHolder.releaseComponent()
    }
}