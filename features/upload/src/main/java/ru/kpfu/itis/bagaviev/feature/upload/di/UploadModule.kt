package ru.kpfu.itis.bagaviev.feature.upload.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.bagaviev.common.di.keys.ViewModelKey
import ru.kpfu.itis.bagaviev.common.di.modules.CoroutineDispatcherModule
import ru.kpfu.itis.bagaviev.common.di.scopes.FeatureScope
import ru.kpfu.itis.bagaviev.feature.upload.presentation.di.UploadPresentationModule
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.UploadViewModel

@Module(
    includes = [
        UploadPresentationModule::class,
        CoroutineDispatcherModule::class
    ]
)
internal interface UploadModule {

    @FeatureScope
    @[Binds IntoMap ViewModelKey(UploadViewModel::class)]
    fun provideFeedViewModel(uploadViewModel: UploadViewModel): ViewModel
}