package ru.kpfu.itis.bagaviev.common.util.extensions

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import jp.wasabeef.blurry.Blurry

fun ImageView.blur(
    radius: Int,
    sampling: Int
) {
    Blurry.with(context)
        .radius(radius)
        .sampling(sampling)
        .capture(this)
        .into(this)
}

fun <T : Fragment> T.blur(
    radius: Int,
    sampling: Int,
    drawable: Drawable,
    target: ImageView
) {
    Blurry.with(context)
        .radius(radius)
        .sampling(sampling)
        .from(drawable.toBitmap())
        .into(target)
}