package ru.kpfu.itis.bagaviev.feature.search.impl.di.submodules

import dagger.Module

@Module(
    includes = [
        TrackUseCasesModule::class,
        PlaylistUseCaseModule::class,
        SearchUseCaseModule::class
    ]
)
interface UseCasesModule