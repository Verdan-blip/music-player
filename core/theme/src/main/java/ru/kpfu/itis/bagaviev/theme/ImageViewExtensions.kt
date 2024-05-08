package ru.kpfu.itis.bagaviev.theme

import android.graphics.Bitmap
import android.widget.ImageView
import jp.wasabeef.blurry.Blurry

fun ImageView.blur() {
    Blurry.with(context)
        .radius(R.integer.blur_radius)
        .sampling(R.integer.blur_sampling)
        .capture(this)
        .into(this)
}

fun ImageView.blur(bitmap: Bitmap) {
    Blurry.with(context)
        .radius(R.integer.blur_radius)
        .sampling(R.integer.blur_sampling)
        .from(bitmap)
        .into(this)
}