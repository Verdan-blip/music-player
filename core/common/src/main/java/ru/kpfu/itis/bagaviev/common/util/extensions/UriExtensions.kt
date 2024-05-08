package ru.kpfu.itis.bagaviev.common.util.extensions

import android.net.Uri
import java.net.URI

fun URI.toUri(): Uri = Uri.parse(toString())

fun Uri.toURI(): URI = URI.create(toString())