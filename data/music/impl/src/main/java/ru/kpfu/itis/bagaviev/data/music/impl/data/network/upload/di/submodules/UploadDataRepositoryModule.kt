package ru.kpfu.itis.bagaviev.data.music.impl.data.network.upload.di.submodules

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.network.upload.repository.UploadTrackDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.upload.repository.UploadTrackDataRepositoryImpl

@Module
interface UploadDataRepositoryModule {

    @Binds
    fun provideUploadDataRepositoryImpl_to_UploadDataRepository(
        uploadTrackDataRepositoryImpl: UploadTrackDataRepositoryImpl
    ): UploadTrackDataRepository
}