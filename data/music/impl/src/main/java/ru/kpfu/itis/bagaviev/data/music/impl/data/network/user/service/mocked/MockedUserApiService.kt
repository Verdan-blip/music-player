package ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.service.mocked

import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.pojo.responses.UserDetailsResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.pojo.responses.UserProfileResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.service.UserApiService
import javax.inject.Inject

class MockedUserApiService @Inject constructor() : UserApiService {

    val users = mutableListOf(
        UserDetailsResponse(
            id = 0,
            login = "ThreeDaysRaining",
            avatarUri = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fspika.org%2Fartists%2Ftri-dnya-dozhdya%2F&psig=AOvVaw1GhLeGafY0mt1rjgy2b69C&ust=1715794096385000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCKj7557VjYYDFQAAAAAdAAAAABAE",
            tracks = listOf(),
            playlists = listOf()
        )
    )

    val userProfile = UserProfileResponse(
        id = 0,
        login = "ThreeDaysRaining",
        email = "three.day.raining@gmail.com",
        avatarUri = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fspika.org%2Fartists%2Ftri-dnya-dozhdya%2F&psig=AOvVaw1GhLeGafY0mt1rjgy2b69C&ust=1715794096385000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCKj7557VjYYDFQAAAAAdAAAAABAE",
        tracks = listOf(),
        playlists = listOf()
    )

    override suspend fun getUserById(userId: Long): UserDetailsResponse? =
        users.getOrNull(userId.toInt())

    override suspend fun getMyUserProfile(): UserProfileResponse =
        userProfile
}