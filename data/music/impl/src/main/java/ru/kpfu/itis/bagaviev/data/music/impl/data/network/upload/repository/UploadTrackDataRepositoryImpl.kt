package ru.kpfu.itis.bagaviev.data.music.impl.data.network.upload.repository

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import ru.kpfu.itis.bagaviev.data.music.api.data.network.upload.entity.TrackUploadFormDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.upload.repository.UploadTrackDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.upload.service.TrackUploadApiService
import javax.inject.Inject

class UploadTrackDataRepositoryImpl @Inject constructor(
    private val trackUploadApiService: TrackUploadApiService
) : UploadTrackDataRepository {

    override suspend fun uploadTrack(trackUploadForm: TrackUploadFormDataEntity) {
        val multipartBodyBuilder = MultipartBody.Builder().apply {
            trackUploadForm.apply {
                addFormDataPart(NAME_TITLE, title)
                addFormDataPart(
                    NAME_SMALL_COVER,
                    smallCoverFile.name,
                    smallCoverFile.asRequestBody("image/*".toMediaType())
                )
                addFormDataPart(
                    NAME_COVER,
                    coverFile.name,
                    coverFile.asRequestBody("image/*".toMediaType())
                )
                addFormDataPart(
                    NAME_AUDIO_FILE,
                    audioFile.name,
                    audioFile.asRequestBody("audio/*".toMediaType())
                )
                clipData?.apply {
                    addFormDataPart(
                        NAME_CLIP_FILE,
                        coverFile.name,
                        coverFile.asRequestBody("video/*".toMediaType())
                    )
                    addFormDataPart(NAME_CLIP_START, clipStartMs.toString())
                    addFormDataPart(NAME_CLIP_END, clipEndMs.toString())
                }
            }
        }
        trackUploadApiService.uploadTrack(multipartBodyBuilder.build())
    }

    companion object {

        const val NAME_TITLE = "title"
        const val NAME_SMALL_COVER = "smallCover"
        const val NAME_COVER = "cover"
        const val NAME_AUDIO_FILE = "audioFile"
        const val NAME_CLIP_FILE = "clipFile"
        const val NAME_CLIP_START = "clipStart"
        const val NAME_CLIP_END = "clipEnd"
    }
}