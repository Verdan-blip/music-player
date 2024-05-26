package ru.kpfu.itis.bagaviev.data.music.impl.data.network.upload.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.upload.di.submodules.UploadApiServiceModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.upload.di.submodules.UploadDataRepositoryModule

@Module(
    includes = [
        UploadApiServiceModule::class,
        UploadDataRepositoryModule::class
    ]
)
interface UploadDataModule