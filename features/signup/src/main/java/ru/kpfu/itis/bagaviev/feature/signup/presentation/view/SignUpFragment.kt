package ru.kpfu.itis.bagaviev.feature.signup.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.kpfu.itis.bagaviev.feature.signup.R
import ru.kpfu.itis.bagaviev.feature.signup.databinding.FragmentSignUpBinding
import ru.kpfu.itis.bagaviev.feature.signup.di.SignUpComponentHolder
import ru.kpfu.itis.bagaviev.feature.signup.presentation.entities.SignUpFormModel

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private var viewBinding: FragmentSignUpBinding? = null

    private val viewModel: SignUpViewModel by viewModels {
        SignUpComponentHolder
            .createComponent(requireContext())
            .viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSignUpBinding.inflate(
            layoutInflater, container, false
        )
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding?.apply {
            tvSignIn.setOnClickListener {
                viewModel.onSignInPress()
            }
            btnSignUp.setOnClickListener {
                viewModel.onSignUpPress(SignUpFormModel(
                    email = etEmail.text.toString(),
                    login = etLogin.text.toString(),
                    password = etPassword.text.toString(),
                    confirmedPassword = etConfirmPassword.text.toString()
                ))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        SignUpComponentHolder.releaseComponent()
    }
}