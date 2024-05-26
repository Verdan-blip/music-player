package ru.kpfu.itis.bagaviev.feature.upload.presentation.util.file_manager

import android.content.Context
import android.media.MediaMetadataRetriever
import android.provider.OpenableColumns
import androidx.core.net.toUri
import javax.inject.Inject

class AndroidVideoMetadataManager @Inject constructor(
    private val context: Context
) : VideoMetadataManager {

    private val retriever = MediaMetadataRetriever()

    override fun extractDuration(uri: String): Long {
        retriever.setDataSource(context, uri.toUri())
        val value = retriever.extractMetadata(
            MediaMetadataRetriever.METADATA_KEY_DURATION
        )
        return value?.toLong() ?: 0L
    }


    override fun extractFileName(uri: String): String? {
        return context.contentResolver.query(
            uri.toUri(), null, null, null, null
        )?.let { cursor ->
            val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            cursor.moveToFirst()
            val fileName = cursor.getString(nameIndex)
            cursor.close()
            fileName
        }
    }
}