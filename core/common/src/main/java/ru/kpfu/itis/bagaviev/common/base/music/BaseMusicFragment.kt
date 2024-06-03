package ru.kpfu.itis.bagaviev.common.base.music

import android.app.AlertDialog
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseMusicFragment(@LayoutRes id: Int) : Fragment(id) {

    protected val musicViewModel by lazy {
        (requireContext() as BaseMusicActivity)
            .musicViewModel
    }

    protected fun showShortToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT)
            .show()
    }

    protected fun showErrorDialog(title: String, message: String) {
        AlertDialog.Builder(requireContext())
            .setTitle(title)
            .setMessage(message)
            .create()
            .show()
    }
}