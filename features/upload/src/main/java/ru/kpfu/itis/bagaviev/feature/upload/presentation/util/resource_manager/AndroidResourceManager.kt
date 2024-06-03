package ru.kpfu.itis.bagaviev.feature.upload.presentation.util.resource_manager

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import ru.kpfu.itis.bagaviev.common.core.ResourceManager
import javax.inject.Inject

class AndroidResourceManager @Inject constructor(
    private val context: Context
) : ResourceManager {

    override fun getString(@StringRes id: Int): String =
        context.getString(id)

    override fun getString(@StringRes id: Int, vararg formatArgs: Any): String =
        context.getString(id, formatArgs)

    override fun getColor(@ColorRes id: Int) =
        ContextCompat.getColor(context, id)

    override fun getDimension(@DimenRes id: Int) =
        context.resources.getDimension(id)

    override fun getDrawable(@DrawableRes id: Int): Drawable? =
        AppCompatResources.getDrawable(context, id)
}