package ru.kpfu.itis.bagaviev.impl.data.mapper

import android.net.Uri
import androidx.core.os.bundleOf
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import ru.kpfu.itis.bagaviev.api.domain.entities.MusicItem
import ru.kpfu.itis.common.util.converters.UriConverter

fun MusicItem.toMediaItem(): MediaItem {
    val mediaMetaData = MediaMetadata.Builder()
        .setTitle(title)
        .setArtist(authors.joinToString(separator = "& "))
        .setArtworkUri(Uri.parse(posterUri.toString()))
        .setMediaType(MediaMetadata.MEDIA_TYPE_MUSIC)
        .setExtras(bundleOf("duration" to duration))
        .build()
    return MediaItem.Builder()
        .setUri(fileUri.toString())
        .setMediaMetadata(mediaMetaData)
        .setMediaId(id.toString())
        .build()
}

fun MediaItem.toMusicItem(): MusicItem {
    return MusicItem(
        id = mediaId.toInt(),
        title = mediaMetadata.title.toString(),
        authors = mediaMetadata.artist?.split("& ") ?: listOf(),
        duration = mediaMetadata.extras?.getLong("duration") ?: 0L,
        posterUri = UriConverter.UriToURI(
            mediaMetadata.artworkUri ?: throw IllegalStateException("Poster uri was not provided")
        ),
        fileUri = UriConverter.UriToURI(
            localConfiguration?.uri ?: throw IllegalStateException("File uri was not provided")
        )
    )
}