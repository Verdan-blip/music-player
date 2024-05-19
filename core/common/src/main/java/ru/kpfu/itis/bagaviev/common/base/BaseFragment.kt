package ru.kpfu.itis.bagaviev.common.base

import android.app.AlertDialog
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import coil.ImageLoader
import coil.request.ErrorResult
import coil.request.ImageRequest
import coil.request.SuccessResult

abstract class BaseFragment(@LayoutRes id: Int) : Fragment(id) {

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

    fun enqueueLoadImageRequest(
        data: Any?,
        allowHardware: Boolean = true,
        onStart: (req: ImageRequest) -> Unit = { _ -> },
        onSuccess: (req: ImageRequest, result: SuccessResult) -> Unit = { _, _ -> },
        onError: (req: ImageRequest, result: ErrorResult) -> Unit = { _, _ -> },
        onCancel: (req: ImageRequest) -> Unit = { _ -> }
    ) {
        val request = ImageRequest.Builder(requireContext())
            .data(data)
            .allowHardware(allowHardware)
            .listener(
                onStart = onStart,
                onSuccess = onSuccess,
                onError = onError,
                onCancel = onCancel
            )
            .build()
        ImageLoader.Builder(requireContext())
            .build()
            .enqueue(request)
    }
}