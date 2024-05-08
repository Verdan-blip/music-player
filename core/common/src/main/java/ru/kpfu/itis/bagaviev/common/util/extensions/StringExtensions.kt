package ru.kpfu.itis.bagaviev.common.util.extensions

import java.net.URI

fun String.toURI(): URI =
    URI(this)