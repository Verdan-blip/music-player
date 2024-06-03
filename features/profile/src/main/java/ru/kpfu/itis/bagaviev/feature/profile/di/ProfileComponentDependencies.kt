package ru.kpfu.itis.bagaviev.feature.profile.di

import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.bagaviev.feature.profile.ProfileRouter
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.FeatureProfileAuthRepository
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.FeatureProfileDownloadedTrackRepository
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.FeatureProfileUserRepository


interface ProfileComponentDependencies : ComponentDependencies {

    val featureProfileAuthRepository: FeatureProfileAuthRepository

    val featureProfileUserRepository: FeatureProfileUserRepository

    val featureProfileDownloadedTrackRepository: FeatureProfileDownloadedTrackRepository

    val profileRouter: ProfileRouter
}