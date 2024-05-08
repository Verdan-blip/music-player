package ru.kpfu.itis.bagaviev.common.util.extensions

fun Long.timeAsProgress(duration: Long): Int {
    return if (duration == 0L) 0 else ((this / duration.toDouble()) * 100).toInt()
}

fun Int.progressAsTime(duration: Long): Long {
    return if (duration == 0L) 0 else this * duration / 100
}