package ru.kpfu.itis.bagaviev.features.profile.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feature.profile.ProfileRouter
import ru.kpfu.itis.bagaviev.features.profile.AdapterProfileRouter

@Module
interface FeatureProfileRouterModule {

    @Binds
    fun provideAdapterProfileRouter_to_ProfileRouter(
        adapterProfileRouter: AdapterProfileRouter
    ): ProfileRouter
}