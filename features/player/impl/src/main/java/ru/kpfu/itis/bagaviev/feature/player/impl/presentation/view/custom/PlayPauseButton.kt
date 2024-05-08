package ru.kpfu.itis.bagaviev.feature.player.impl.presentation.view.custom

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import ru.kpfu.itis.bagaviev.feature.player.impl.R

class PlayPauseButton : AppCompatButton {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initDrawableResources(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        initDrawableResources(attrs)
    }

    private fun initDrawableResources(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.PlayPauseButton)
        playDrawableRes = typedArray.getDrawable(R.styleable.PlayPauseButton_playStateDrawable)
        pauseDrawableRes = typedArray.getDrawable(R.styleable.PlayPauseButton_pauseStateDrawable)
        typedArray.recycle()
        state = ButtonState.PAUSE
    }


    enum class ButtonState { PLAY, PAUSE }

    private var playDrawableRes: Drawable? = null
    private var pauseDrawableRes: Drawable? = null

    var state: ButtonState = ButtonState.PLAY
        set(value) {
            field = value
            when (value) {
                ButtonState.PLAY -> setBackgroundDrawable(pauseDrawableRes)
                ButtonState.PAUSE -> setBackgroundDrawable(playDrawableRes)
            }
        }

}