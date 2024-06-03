package ru.kpfu.itis.bagaviev.player.api.domain.repository

import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem

interface MusicDownloadRepository {

    suspend fun startDownloading(musicItem: MusicItem): Long?

    suspend fun stopDownloading(id: String)

    suspend fun pauseDownloads()

    suspend fun resumeDownloads()
}