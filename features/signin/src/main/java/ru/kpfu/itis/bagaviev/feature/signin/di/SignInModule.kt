package ru.kpfu.itis.bagaviev.feature.signin.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.bagaviev.common.di.keys.ViewModelKey
import ru.kpfu.itis.bagaviev.common.di.scopes.FeatureScope
import ru.kpfu.itis.bagaviev.feature.signin.presentation.view.SignInViewModel

@Module
interface SignInModule {

    @FeatureScope
    @[Binds IntoMap ViewModelKey(SignInViewModel::class)]
    fun provideFeedViewModel(signInViewModel: SignInViewModel): ViewModel
}