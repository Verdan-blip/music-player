package ru.kpfu.itis.bagaviev.feature.upload.di

import android.content.Context
import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureSearchUserRepository
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureUploadTrackRepository

interface UploadComponentDependencies : ComponentDependencies {

    val featureUploadTrackRepository: FeatureUploadTrackRepository

    val featureSearchUserRepository: FeatureSearchUserRepository

    val context: Context
}