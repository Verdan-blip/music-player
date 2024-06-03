package ru.kpfu.itis.bagaviev.player.impl.data.mappers

import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import ru.kpfu.itis.bagaviev.player.api.domain.entities.ClipData
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem
import ru.kpfu.itis.bagaviev.player.impl.data.exceptions.AudioFileUriNotProvidedException
import ru.kpfu.itis.bagaviev.player.impl.data.exceptions.AuthorsNotProvidedException
import ru.kpfu.itis.bagaviev.player.impl.data.exceptions.CoverUriNotProvidedException


const val AUTHORS_SEPARATOR = " &"
const val KEY_CLIP_URI = "clipUri"
const val KEY_CLIP_START = "clipStart"
const val KEY_CLIP_END = "clipEnd"


fun MusicItem.toMediaItem(): MediaItem {
    val mediaMetadata = MediaMetadata.Builder()
        .setTitle(title)
        .setArtworkUri(coverUri.toUri())
        .setArtist(authors.joinToString(AUTHORS_SEPARATOR))
        .setExtras(
            bundleOf(
                KEY_CLIP_URI to clipData?.clipUri,
                KEY_CLIP_START to clipData?.clipStart,
                KEY_CLIP_END to clipData?.clipEnd
            )
        )
        .build()

    return MediaItem.Builder()
        .setMediaMetadata(mediaMetadata)
        .setMediaId(id.toString())
        .setUri(audioFileUri.toUri())
        .build()
}

fun MediaItem.toMusicItem(): MusicItem {
    val clipData = mediaMetadata.extras?.run {
        getString(KEY_CLIP_URI)?.let { uri ->
            ClipData(
                clipUri = uri,
                clipStart = getLong(KEY_CLIP_START),
                clipEnd = getLong(KEY_CLIP_END)
            )
        }
    }
    return MusicItem(
        id = mediaId.toLong(),
        title = mediaMetadata.title.toString(),
        audioFileUri = localConfiguration?.uri?.toString()
            ?: throw AudioFileUriNotProvidedException(),
        coverUri = mediaMetadata.artworkUri?.toString() ?: throw CoverUriNotProvidedException(),
        authors = mediaMetadata.artist?.split(AUTHORS_SEPARATOR)
            ?: throw AuthorsNotProvidedException(),
        clipData = clipData
    )
}