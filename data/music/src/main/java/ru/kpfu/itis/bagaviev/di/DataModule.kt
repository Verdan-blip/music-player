package ru.kpfu.itis.bagaviev.di

import dagger.Module

@Module(
    includes = [NetworkModule::class]
)
interface DataModule