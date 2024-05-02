package ru.kpfu.itis.bagaviev.music.di

import dagger.Module

@Module(
    includes = [NetworkModule::class]
)
interface DataModule