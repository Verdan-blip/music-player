package ru.kpfu.itis.bagaviev.feature.upload.presentation.util.file_manager

interface VideoMetadataManager {

    fun extractDuration(uri: String): Long

    fun extractFileName(uri: String): String?
}