package ru.kpfu.itis.bagaviev.data.music.impl.data.network.upload.service

import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface TrackUploadApiService {

    @Multipart
    @POST("/api/v1/tracks/upload")
    suspend fun uploadTrack(
        @Part title: MultipartBody.Part,
        @Part genre: MultipartBody.Part,
        @Part authorIds: MultipartBody.Part? = null,
        @Part cover: MultipartBody.Part,
        @Part smallCover: MultipartBody.Part? = null,
        @Part lyrics: MultipartBody.Part? = null,
        @Part audioFile: MultipartBody.Part,
        @Part clipFile: MultipartBody.Part? = null,
        @Part clipStart: MultipartBody.Part? = null,
        @Part clipEnd: MultipartBody.Part? = null
    )
}