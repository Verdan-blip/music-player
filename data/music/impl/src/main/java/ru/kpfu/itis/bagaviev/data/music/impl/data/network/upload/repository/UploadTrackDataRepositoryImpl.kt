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
        trackUploadForm.apply {

            var clipMultipartBody: MultipartBody.Part? = null
            var clipEndMultipartBody: MultipartBody.Part? = null
            var clipStartMultipartBody: MultipartBody.Part? = null

            var smallCover: MultipartBody.Part? = null

            clipData?.apply {
                clipMultipartBody = MultipartBody.Part.createFormData(
                    NAME_CLIP_FILE, clipData?.clipFile?.name, clipFile.asRequestBody("video/*".toMediaType())
                )
                clipStartMultipartBody = MultipartBody.Part.createFormData(
                    NAME_CLIP_START, clipStartMs.toString()
                )
                clipEndMultipartBody = MultipartBody.Part.createFormData(
                    NAME_CLIP_END, clipEndMs.toString()
                )
            }

            smallCover = smallCoverFile?.let { file ->
                MultipartBody.Part.createFormData(
                    NAME_COVER, file.name, file.asRequestBody("image/*".toMediaType())
                )
            }

            trackUploadApiService.uploadTrack(
                title = MultipartBody.Part.createFormData(NAME_TITLE, title),
                genre = MultipartBody.Part.createFormData(NAME_GENRE, genre),
                authorIds = MultipartBody.Part.createFormData(
                    NAME_AUTHOR_IDS,
                    users.joinToString(separator = ",") { userDataEntity ->
                        userDataEntity.id.toString()
                    }
                ),
                cover = MultipartBody.Part.createFormData(
                    NAME_COVER, coverFile.name, coverFile.asRequestBody("image/*".toMediaType())
                ),
                smallCover = smallCover,
                audioFile = MultipartBody.Part.createFormData(
                    NAME_AUDIO_FILE, audioFile.name, audioFile.asRequestBody("audio/*".toMediaType())
                ),
                clipFile = clipMultipartBody,
                clipStart = clipStartMultipartBody,
                clipEnd = clipEndMultipartBody,
            )
        }
    }

    companion object {

        const val NAME_TITLE = "title"
        const val NAME_GENRE = "genre"
        const val NAME_AUTHOR_IDS = "authorIds"
        const val NAME_SMALL_COVER = "smallCover"
        const val NAME_COVER = "cover"
        const val NAME_AUDIO_FILE = "audioFile"
        const val NAME_CLIP_FILE = "clipFile"
        const val NAME_CLIP_START = "clipStart"
        const val NAME_CLIP_END = "clipEnd"
    }
}