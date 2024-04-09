package ru.kpfu.itis.bagaviev.player.presentation.util

import java.util.concurrent.TimeUnit

object MusicProgressUtil {

    fun getValueInPercents(duration: Long, currentProgressTime: Long): Float =
        (currentProgressTime.toFloat() / duration)

    fun formatDuration(duration: Long): String {
        val minutes = TimeUnit.MINUTES.convert(duration, TimeUnit.MILLISECONDS)
        val seconds = TimeUnit.SECONDS.convert(duration, TimeUnit.MILLISECONDS).mod(60)
        return String.format("%02d:%02d", minutes, seconds)
    }

}