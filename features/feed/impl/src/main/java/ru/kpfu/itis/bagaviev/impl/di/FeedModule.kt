package ru.kpfu.itis.bagaviev.impl.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.bagaviev.impl.di.submodules.PlaylistUseCaseModule
import ru.kpfu.itis.bagaviev.impl.di.submodules.TrackUseCasesModule
import ru.kpfu.itis.bagaviev.impl.presentation.view.FeedViewModel
import ru.kpfu.itis.common.di.keys.ViewModelKey
import ru.kpfu.itis.common.di.scopes.FeatureScope

@Module(
    includes = [TrackUseCasesModule::class, PlaylistUseCaseModule::class]
)
internal interface FeedModule {

    @FeatureScope
    @[Binds IntoMap ViewModelKey(FeedViewModel::class)]
    fun provideFeedViewModel(feedViewModel: FeedViewModel): ViewModel
}