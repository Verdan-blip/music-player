@file:OptIn(UnstableApi::class) package ru.kpfu.itis.bagaviev.player.impl.data.impl

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.annotation.OptIn
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.media3.common.util.UnstableApi
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem
import ru.kpfu.itis.bagaviev.player.api.domain.repository.MusicDownloadRepository
import javax.inject.Inject

class MusicDownloadRepositoryImpl @Inject constructor(
    private val context: Context
) : MusicDownloadRepository {

    private val downloadManager = ContextCompat.getSystemService(
        context, DownloadManager::class.java
    )

    override suspend fun startDownloading(musicItem: MusicItem): Long? {
        val fileName = FILE_NAME_FORMAT.format(musicItem.title, musicItem.id)
        val downloadRequest = DownloadManager.Request(musicItem.audioFileUri.toUri())
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName)
        return downloadManager?.enqueue(downloadRequest)
    }

    override suspend fun stopDownloading(id: String) {
    }

    override suspend fun pauseDownloads() {
    }

    override suspend fun resumeDownloads() {
    }

    companion object {

        val FILE_NAME_FORMAT = "muztache_track_%s_%d"
    }
}