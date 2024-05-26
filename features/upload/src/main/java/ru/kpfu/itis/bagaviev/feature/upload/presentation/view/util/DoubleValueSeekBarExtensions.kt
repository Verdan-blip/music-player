package ru.kpfu.itis.bagaviev.feature.upload.presentation.view.util

import com.mohammedalaa.seekbar.DoubleValueSeekBarView
import com.mohammedalaa.seekbar.OnDoubleValueSeekBarChangeListener

fun DoubleValueSeekBarView.setOnRangeSeekBarViewChangeListener(
    onStartTrackingTouch: (
        seekBar: DoubleValueSeekBarView?,
        min: Int,
        max: Int) -> Unit = { _, _, _ -> },
    onStopTrackingTouch: (
        seekBar: DoubleValueSeekBarView?,
        min: Int,
        max: Int) -> Unit = { _, _, _ -> },
    onValueChanged: (
        seekBar: DoubleValueSeekBarView?,
        min: Int,
        max: Int,
        fromUser: Boolean) -> Unit = { _, _, _, _ -> }
) {
    setOnRangeSeekBarViewChangeListener(object : OnDoubleValueSeekBarChangeListener {

        override fun onStartTrackingTouch(seekBar: DoubleValueSeekBarView?, min: Int, max: Int) {
            onStartTrackingTouch(seekBar, min, max)
        }

        override fun onStopTrackingTouch(seekBar: DoubleValueSeekBarView?, min: Int, max: Int) {
            onStopTrackingTouch(seekBar, min, max)
        }

        override fun onValueChanged(
            seekBar: DoubleValueSeekBarView?,
            min: Int,
            max: Int,
            fromUser: Boolean
        ) {
            onValueChanged(seekBar, min, max, fromUser)
        }
    })
}