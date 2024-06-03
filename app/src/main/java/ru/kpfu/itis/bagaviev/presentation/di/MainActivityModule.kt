package ru.kpfu.itis.bagaviev.presentation.di

import dagger.Module

@Module(
    includes = [
        MainActivityPlayerModule::class
    ]
)
interface MainActivityModule