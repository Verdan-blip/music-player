package ru.kpfu.itis.bagaviev.feature.signup.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.bagaviev.common.di.keys.ViewModelKey
import ru.kpfu.itis.bagaviev.common.di.scopes.FeatureScope
import ru.kpfu.itis.bagaviev.feature.signup.presentation.SignUpViewModel

@Module
internal interface SignUpModule {

    @FeatureScope
    @[Binds IntoMap ViewModelKey(SignUpViewModel::class)]
    fun provideFeedViewModel(signUpViewModel: SignUpViewModel): ViewModel
}