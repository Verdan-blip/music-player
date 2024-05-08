package ru.kpfu.itis.bagaviev.player.impl.data.mappers

import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import ru.kpfu.itis.bagaviev.common.util.extensions.toURI
import ru.kpfu.itis.bagaviev.common.util.extensions.toUri
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem
import ru.kpfu.itis.bagaviev.player.impl.data.exceptions.AudioFileUriNotProvidedException
import ru.kpfu.itis.bagaviev.player.impl.data.exceptions.AuthorsNotProvidedException
import ru.kpfu.itis.bagaviev.player.impl.data.exceptions.CoverUriNotProvidedException

fun MusicItem.toMediaItem(): MediaItem {
    val mediaMetadata = MediaMetadata.Builder()
        .setTitle(title)
        .setArtworkUri(coverUri.toUri())
        .setArtist(authors.joinToString(separator = " & "))
        .setGenre(genre)
        .build()

    return MediaItem.Builder()
        .setMediaMetadata(mediaMetadata)
        .setMediaId(id.toString())
        .setUri(audioFileUri.toUri())
        .build()
}

fun MediaItem.toMusicItem(): MusicItem =
    MusicItem(
        id = mediaId.toLong(),
        title = mediaMetadata.title.toString(),
        authors = mediaMetadata.artist?.split(" & ") ?: throw AuthorsNotProvidedException(),
        genre = mediaMetadata.genre.toString(),
        audioFileUri = localConfiguration?.uri?.toURI() ?: throw AudioFileUriNotProvidedException(),
        coverUri = mediaMetadata.artworkUri?.toURI() ?: throw CoverUriNotProvidedException()
    )