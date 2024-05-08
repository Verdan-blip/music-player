package ru.kpfu.itis.oauth.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.kpfu.itis.bagaviev.common.states.CustomTabsState
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.oauth.R
import ru.kpfu.itis.oauth.databinding.FragmentOauthBinding
import ru.kpfu.itis.oauth.di.OAuthComponentHolder

class OAuthFragment : Fragment(R.layout.fragment_oauth) {

    private var viewBinding: FragmentOauthBinding? = null

    private val viewModel: OAuthViewModel by viewModels {
        OAuthComponentHolder.createComponent(requireContext())
            .viewModelFactory
    }

    private fun observeCustomTabsState(customTabsState: CustomTabsState) {
        when (customTabsState) {
            is CustomTabsState.Opened -> {
                val uri = customTabsState.uri
                val customTabsIntent = CustomTabsIntent.Builder()
                    .setShowTitle(true)
                    .setInstantAppsEnabled(true)
                    .build()
                customTabsIntent.launchUrl(requireContext(), uri)
            }
            is CustomTabsState.Closed, CustomTabsState.NoAction -> { }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentOauthBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.customTabsState.observe(viewLifecycleOwner, ::observeCustomTabsState)

        viewBinding?.apply {
            btnAuthenticate.setOnClickListener {
                viewModel.onAuthenticateButtonPressed()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        OAuthComponentHolder.releaseComponent()
    }
}