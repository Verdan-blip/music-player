package ru.kpfu.itis.bagaviev.player.impl.presentation.broadcast_receiver

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat

class DownloadCompletionBroadcastReceiver(
    private val action: (downloadId: Long, newUri: String) -> Unit
) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.apply {
            context?.also { ctx ->
                val downloadManager = ContextCompat.getSystemService(
                    ctx, DownloadManager::class.java
                )
                val id = getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
                if (id != -1L) {
                    downloadManager?.getUriForDownloadedFile(id)?.also { newUri ->
                        action(id, newUri.toString())
                    }
                }
            }
        }
    }
}