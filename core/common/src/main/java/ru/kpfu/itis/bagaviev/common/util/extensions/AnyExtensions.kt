package ru.kpfu.itis.bagaviev.common.util.extensions

fun <T> T?.foldNullability(onNotNull: (T) -> Unit, onNull: () -> Unit) {
    if (this == null)
        onNull()
    else
        onNotNull(this)
}