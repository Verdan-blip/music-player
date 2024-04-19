package ru.kpfu.itis.common.di.connector.holders

import ru.kpfu.itis.common.di.DiComponent

interface ComponentHolder<T : DiComponent> {

    fun requireComponent(): T
}