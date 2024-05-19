package ru.kpfu.itis.bagaviev.theme.util

data class MusicProgress(
    val progressInMs: Long = 0L,
    val duration: Long = 0L
) {

    fun getProgressNormalized(): Int =
        (progressInMs / duration).toInt()

    fun getProgressAsTime(): String {
        val minutes = progressInMs / (1000 * 60)
        val seconds = progressInMs / 1000 % 60
        return "%02d:%02d".format(minutes, seconds)
    }
}