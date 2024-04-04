package ru.kpfu.itis.common.di.connector.holders

import android.content.Context
import ru.kpfu.itis.common.di.DiComponent

interface ComponentHolder<T : DiComponent> {

    fun get(context: Context): T

    fun set(component: T)
}