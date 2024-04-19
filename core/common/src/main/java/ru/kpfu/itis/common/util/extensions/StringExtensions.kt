package ru.kpfu.itis.common.util.extensions

import java.net.URI

fun String.toURI(): URI =
    URI(this)