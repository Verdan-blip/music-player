package ru.kpfu.itis.bagaviev.feature.profile.presentation.view.track

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.kpfu.itis.bagaviev.feature.profile.R
import ru.kpfu.itis.bagaviev.feature.profile.databinding.FragmentTracksBinding
import ru.kpfu.itis.bagaviev.feature.profile.presentation.view.ProfileViewModel

class SavedTracksFragment : Fragment(R.layout.fragment_tracks) {

    private var viewBinding: FragmentTracksBinding? = null

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[ProfileViewModel::class.java]
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}