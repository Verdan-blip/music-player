package ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.client.AuthenticatedClientModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.client.PublicClientModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.retrofit.AuthenticatedRetrofitModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.retrofit.PublicRetrofitModule

@Module(
    includes = [
        AuthenticatedClientModule::class,
        AuthenticatedRetrofitModule::class,
        PublicClientModule::class,
        PublicRetrofitModule::class
    ]
)
interface ApiCoreModule