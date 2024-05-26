package ru.kpfu.itis.bagaviev.feature.upload.presentation.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feature.upload.presentation.util.file_manager.AndroidVideoMetadataManager
import ru.kpfu.itis.bagaviev.feature.upload.presentation.util.file_manager.VideoMetadataManager

@Module
interface UploadPresentationModule {

    @Binds
    fun provideAndroidMetadataVideoManager_to_VideoMetadataManager(
        androidVideoMetadataManager: AndroidVideoMetadataManager
    ): VideoMetadataManager
}