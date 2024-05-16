package ru.kpfu.itis.bagaviev.feature.profile.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.bagaviev.common.di.keys.ViewModelKey
import ru.kpfu.itis.bagaviev.common.di.scopes.FeatureScope
import ru.kpfu.itis.bagaviev.feature.profile.presentation.view.ProfileViewModel

@Module
interface ProfileModule {

    @Binds
    @[FeatureScope IntoMap ViewModelKey(ProfileViewModel::class)]
    fun provideProfileViewModel(profileViewModel: ProfileViewModel): ViewModel
}