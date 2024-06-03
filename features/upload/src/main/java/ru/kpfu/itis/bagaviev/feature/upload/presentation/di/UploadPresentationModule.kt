package ru.kpfu.itis.bagaviev.feature.upload.presentation.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.common.core.ResourceManager
import ru.kpfu.itis.bagaviev.feature.upload.presentation.util.file_manager.AndroidVideoMetadataManager
import ru.kpfu.itis.bagaviev.feature.upload.presentation.util.file_manager.VideoMetadataManager
import ru.kpfu.itis.bagaviev.feature.upload.presentation.util.resource_manager.AndroidResourceManager

@Module
interface UploadPresentationModule {

    @Binds
    fun provideAndroidMetadataVideoManager_to_VideoMetadataManager(
        androidVideoMetadataManager: AndroidVideoMetadataManager
    ): VideoMetadataManager

    @Binds
    fun provideAndroidResourceManager_to_ResourceManager(
        resourceManager: AndroidResourceManager
    ): ResourceManager
}