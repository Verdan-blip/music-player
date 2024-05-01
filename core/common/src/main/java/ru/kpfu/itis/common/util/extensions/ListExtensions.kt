package ru.kpfu.itis.common.util.extensions

fun <T> List<T>.second(): T {
    if (size < 2)
        throw NoSuchElementException("List size is less than 2.")
    return this[1]
}

fun <T> List<T>.secondOrNull(): T? {
    if (size < 2)
        return null
    return this[1]
}