package ru.kpfu.itis.bagaviev.feed.impl.di.submodules

import dagger.Module
import ru.kpfu.itis.bagaviev.feed.impl.di.submodules.usecases.PlaylistUseCaseModule
import ru.kpfu.itis.bagaviev.feed.impl.di.submodules.usecases.TrackUseCasesModule

@Module(
    includes = [TrackUseCasesModule::class, PlaylistUseCaseModule::class]
)
interface FeedUseCasesModule