package ru.kpfu.itis.bagaviev.impl.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.kpfu.itis.bagaviev.impl.R
import ru.kpfu.itis.bagaviev.impl.databinding.FragmentFeedBinding

class FeedFragment : Fragment(R.layout.fragment_feed) {

    private var viewBinding: FragmentFeedBinding? = null

    private val viewModel: FeedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentFeedBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}