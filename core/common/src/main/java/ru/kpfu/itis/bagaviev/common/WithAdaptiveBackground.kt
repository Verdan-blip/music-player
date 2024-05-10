package ru.kpfu.itis.bagaviev.common

import android.graphics.Bitmap
import android.graphics.drawable.Drawable

interface WithAdaptiveBackground {

    fun updateBackground(drawable: Drawable)
}