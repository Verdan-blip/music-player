package ru.kpfu.itis.oauth.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.common.di.keys.ViewModelKey
import ru.kpfu.itis.common.di.scopes.FeatureScope
import ru.kpfu.itis.oauth.presentation.OAuthViewModel

@Module
interface OAuthModule {

    @FeatureScope
    @[Binds IntoMap ViewModelKey(OAuthViewModel::class)]
    fun provideOAuthViewModel(oAuthViewModel: OAuthViewModel): ViewModel
}