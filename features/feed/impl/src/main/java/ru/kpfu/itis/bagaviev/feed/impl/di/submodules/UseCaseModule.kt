package ru.kpfu.itis.bagaviev.feed.impl.di.submodules

import dagger.Module
import ru.kpfu.itis.bagaviev.feed.impl.di.submodules.usecase.FeedUseCaseModule
import ru.kpfu.itis.bagaviev.feed.impl.di.submodules.usecase.PlaylistUseCaseModule
import ru.kpfu.itis.bagaviev.feed.impl.di.submodules.usecase.TrackUseCasesModule

@Module(
    includes = [
        TrackUseCasesModule::class,
        PlaylistUseCaseModule::class,
        FeedUseCaseModule::class
    ]
)
internal interface UseCaseModule