package ru.kpfu.itis.bagaviev.feature.profile.di

import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.bagaviev.feature.profile.ProfileRouter
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.ProfileAuthRepository
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.UserRepository


interface ProfileComponentDependencies : ComponentDependencies {

    val profileAuthRepository: ProfileAuthRepository

    val userRepository: UserRepository

    val profileRouter: ProfileRouter
}