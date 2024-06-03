package ru.kpfu.itis.bagaviev.common.base.music

import androidx.annotation.LayoutRes
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseMusicBottomSheetFragment(@LayoutRes id: Int) : BottomSheetDialogFragment(id) {

    protected val musicViewModel by lazy {
        (requireContext() as BaseMusicActivity)
            .musicViewModel
    }
}