package ru.kpfu.itis.bagaviev.feed.impl.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.FeedViewModel
import ru.kpfu.itis.bagaviev.common.di.keys.ViewModelKey
import ru.kpfu.itis.bagaviev.common.di.scopes.FeatureScope
import ru.kpfu.itis.bagaviev.feed.impl.di.submodules.RepositoryModule
import ru.kpfu.itis.bagaviev.feed.impl.di.submodules.UseCaseModule

@Module(
    includes = [
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
internal interface FeedModule {

    @FeatureScope
    @[Binds IntoMap ViewModelKey(FeedViewModel::class)]
    fun provideFeedViewModel(feedViewModel: FeedViewModel): ViewModel
}