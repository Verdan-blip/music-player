package ru.kpfu.itis.bagaviev.common.util.listeners

import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener

inline fun SeekBar.setOnSeekBarChangeListener(
    crossinline onProgressChanged: (seekBar: SeekBar?, progress: Int, fromUser: Boolean) -> Unit = { _, _, _ -> },
    crossinline onStartTrackingTouch: (seekBar: SeekBar?) -> Unit = { _ -> },
    crossinline onStopTrackingTouch: (seekBar: SeekBar?) -> Unit = { _, -> }
) {
    setOnSeekBarChangeListener(object : OnSeekBarChangeListener {

        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            onProgressChanged(seekBar, progress, fromUser)
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {
            onStartTrackingTouch(seekBar)
        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {
            onStopTrackingTouch(seekBar)
        }
    })
}