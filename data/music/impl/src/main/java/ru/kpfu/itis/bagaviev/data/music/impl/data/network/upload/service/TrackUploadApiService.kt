package ru.kpfu.itis.bagaviev.data.music.impl.data.network.upload.service

import okhttp3.MultipartBody
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface TrackUploadApiService {

    @Multipart
    @POST("/api/v1/tracks/upload")
    suspend fun uploadTrack(@Part multipart: MultipartBody)
}