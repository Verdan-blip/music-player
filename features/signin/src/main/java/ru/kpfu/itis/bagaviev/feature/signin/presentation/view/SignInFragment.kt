package ru.kpfu.itis.bagaviev.feature.signin.presentation.view

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.kpfu.itis.bagaviev.common.base.BaseFragment
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.bagaviev.feature.signin.R
import ru.kpfu.itis.bagaviev.feature.signin.databinding.FragmentSignInBinding
import ru.kpfu.itis.bagaviev.feature.signin.di.SignInComponentHolder
import ru.kpfu.itis.bagaviev.feature.signin.presentation.entity.SignInFormModel

class SignInFragment : BaseFragment(R.layout.fragment_sign_in) {

    private var viewBinding: FragmentSignInBinding? = null

    private val viewModel: SignInViewModel by viewModels {
        SignInComponentHolder
            .createComponent(requireContext())
            .viewModelFactory
    }

    private fun observeErrorState(message: String) {
        showErrorDialog("Error", message)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSignInBinding.inflate(
            layoutInflater, container, false
        )
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            errorAlert.observe(viewLifecycleOwner, ::observeErrorState)
        }

        viewBinding?.apply {
            tvSignUp.setOnClickListener {
                viewModel.onSignUpPress()
            }
            btnLogin.setOnClickListener {
                viewModel.onSignInPress(SignInFormModel(
                    login = etLogin.text.toString(),
                    password = etPassword.text.toString()
                ))
            }
        }
    }
}