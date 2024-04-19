package ru.kpfu.itis.bagaviev.impl.util

object TimeFormatter {

    fun millisToMmSs(time: Long): String {
        val minutes = time / (1000 * 60)
        val seconds = time / 1000 % 60
        return "%02d:%02d".format(minutes, seconds)
    }
}