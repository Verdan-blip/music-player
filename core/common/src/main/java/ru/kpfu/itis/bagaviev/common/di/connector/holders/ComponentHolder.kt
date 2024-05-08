package ru.kpfu.itis.bagaviev.common.di.connector.holders

import ru.kpfu.itis.bagaviev.common.di.DiComponent

interface ComponentHolder<T : DiComponent> {

    fun releaseComponent()
}