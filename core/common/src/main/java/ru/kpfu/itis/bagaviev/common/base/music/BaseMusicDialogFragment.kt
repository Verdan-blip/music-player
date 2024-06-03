package ru.kpfu.itis.bagaviev.common.base.music

import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment

abstract class BaseMusicDialogFragment(@LayoutRes id: Int) : DialogFragment(id) {

    protected val musicViewModel by lazy {
        (requireContext() as BaseMusicActivity)
            .musicViewModel
    }
}