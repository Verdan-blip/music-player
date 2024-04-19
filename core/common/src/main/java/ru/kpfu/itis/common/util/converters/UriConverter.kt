package ru.kpfu.itis.common.util.converters

import android.net.Uri
import java.net.URI

object UriConverter {

    fun URItoUri(uri: URI): Uri =
        Uri.parse(uri.toString())

    fun UriToURI(uri: Uri): URI =
        URI(uri.toString())
}