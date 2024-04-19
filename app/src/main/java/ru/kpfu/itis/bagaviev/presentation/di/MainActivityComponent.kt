package ru.kpfu.itis.bagaviev.presentation.di

import dagger.Component

@MainActivityScope
@Component
interface MainActivityComponent {

    @Component.Factory
    interface Factory {

        fun create(): MainActivityComponent
    }
}