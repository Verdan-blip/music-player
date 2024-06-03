package ru.kpfu.itis.bagaviev.player.impl.presentation.service

import android.content.Intent
import android.os.Build
import androidx.media3.session.MediaSession
import androidx.media3.session.MediaSessionService
import ru.kpfu.itis.bagaviev.player.impl.presentation.PlayerLocator

class PlayerService : MediaSessionService() {

    private var mediaSession: MediaSession? = null

    override fun onCreate() {
        super.onCreate()

        PlayerLocator.provideContext(this)
        PlayerLocator.player?.also { player ->
            mediaSession = MediaSession.Builder(this, player).build()
        }
    }

    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo): MediaSession? =
        mediaSession

    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
        mediaSession?.apply {
            if (!player.playWhenReady || player.mediaItemCount == 0) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    stopForeground(STOP_FOREGROUND_REMOVE)
                }
                stopSelf()
            }
        }
    }

    override fun onDestroy() {
        mediaSession?.apply {
            player.release()
            release()
            mediaSession = null
        }
        super.onDestroy()
    }
}