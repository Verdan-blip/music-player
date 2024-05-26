package ru.kpfu.itis.bagaviev.feature.upload.di

import dagger.Component
import ru.kpfu.itis.bagaviev.common.di.DiComponent
import ru.kpfu.itis.bagaviev.common.di.scopes.FeatureScope
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.UploadViewModel

@FeatureScope
@Component(
    dependencies = [UploadComponentDependencies::class],
    modules = [
        UploadModule::class
    ]
)
interface UploadComponent : DiComponent {

    val viewModelFactory: UploadViewModel.Companion.Factory

    @Component.Factory
    interface Factory {

        fun create(uploadComponentDependencies: UploadComponentDependencies): UploadComponent
    }
}