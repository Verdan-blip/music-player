package ru.kpfu.itis.bagaviev.common.core

import android.graphics.drawable.Drawable

interface ResourceManager {

    fun getString(id: Int): String

    fun getString(id: Int, vararg formatArgs: Any): String

    fun getDrawable(id: Int): Drawable?

    fun getColor(id: Int): Int

    fun getDimension(id: Int): Float
}