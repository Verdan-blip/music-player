package ru.kpfu.itis.bagaviev.feature.upload.di

import android.content.Context
import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.bagaviev.feature.upload.UploadRouter
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureUploadAuthRepository
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureUploadSearchRepository
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureUploadTrackRepository

interface UploadComponentDependencies : ComponentDependencies {

    val featureUploadTrackRepository: FeatureUploadTrackRepository

    val featureUploadSearchRepository: FeatureUploadSearchRepository

    val featureUploadAuthRepository: FeatureUploadAuthRepository

    val uploadRouter: UploadRouter

    val context: Context
}