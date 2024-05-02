package ru.kpfu.itis.bagaviev.music.data.tracks.service.mocked

import ru.kpfu.itis.bagaviev.music.data.tracks.entities.responses.TrackDetailsResponseEntity
import ru.kpfu.itis.bagaviev.music.data.tracks.entities.responses.TrackResponseEntity
import ru.kpfu.itis.bagaviev.music.data.tracks.service.TrackApiService
import ru.kpfu.itis.bagaviev.music.data.users.entites.responses.UserResponseEntity

class MockedTrackApiService : TrackApiService {

    private val chartTracksList = listOf(
        TrackResponseEntity(
            id = 0,
            title = "За край",
            users = listOf(UserResponseEntity(0, "Три дня дождя")),
            smallCoverUri = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3iOzfUInwxoUCePoW8sOM57Ug9Ugij_zAw_na6QtKZw&s"
        ),
        TrackResponseEntity(
            id = 1,
            title = "Демоны",
            users = listOf(UserResponseEntity(0, "Три дня дождя")),
            smallCoverUri = "https://images.genius.com/e8691291312094d39ef1d579b02be640.300x300x1.jpg"
        ),
        TrackResponseEntity(
            id = 2,
            title = "Bad guy",
            users = listOf(UserResponseEntity(1, "Billie Eilish")),
            smallCoverUri = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaYxW05-O5D1LMMBz_ldqrgXLGIKq2eggGGOEqhYQwzQ&s"
        ),
    )

    private val tracksDetailsList = listOf(
        TrackDetailsResponseEntity(
            id = 0,
            title = "За край",
            users = listOf(UserResponseEntity(0, "Три дня дождя")),
            coverUri = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3iOzfUInwxoUCePoW8sOM57Ug9Ugij_zAw_na6QtKZw&s",
            smallCoverUri = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3iOzfUInwxoUCePoW8sOM57Ug9Ugij_zAw_na6QtKZw&s",
            genre = "Pop-rok",
            lyrics = null,
            audioFileUri = "https://dnl4.drivemusic.me/dl/G7W141_QUJJ4ltHx68Hy6w/1714280782/download_music/2023/04/tri-dnja-dozhdja-za-krajj.mp3",
            videoFileUri = null,
            releaseDate = "2024-04-30",
            playsCount = 30
        ),
        TrackDetailsResponseEntity(
            id = 1,
            title = "Демоны",
            users = listOf(UserResponseEntity(0, "Три дня дождя")),
            coverUri = "https://images.genius.com/e8691291312094d39ef1d579b02be640.300x300x1.jpg",
            smallCoverUri = "https://images.genius.com/e8691291312094d39ef1d579b02be640.300x300x1.jpg",
            genre = "Pop-rok",
            lyrics = null,
            audioFileUri = "https://s.muzrecord.com/files/tri-dnya-dozhdya-demony.mp3",
            videoFileUri = null,
            releaseDate = "2024-04-30",
            playsCount = 30
        ),
        TrackDetailsResponseEntity(
            id = 2,
            title = "Bad guy",
            users = listOf(UserResponseEntity(1, "Billie Eilish")),
            coverUri = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaYxW05-O5D1LMMBz_ldqrgXLGIKq2eggGGOEqhYQwzQ&s",
            smallCoverUri = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaYxW05-O5D1LMMBz_ldqrgXLGIKq2eggGGOEqhYQwzQ&s",
            genre = "Pop",
            lyrics = null,
            audioFileUri = "https://mustiny.com/file/YWJhMzNmNDk4MmE3NThjZjg3NDZiZjVjZGNjMWZjYmZ8bG9hZA.mp3",
            videoFileUri = null,
            releaseDate = "2024-04-30",
            playsCount = 30
        )
    )

    override suspend fun getCharts(limit: Int, offset: Int): List<TrackResponseEntity> =
        chartTracksList

    override suspend fun getById(trackId: Long): TrackDetailsResponseEntity? =
        tracksDetailsList.find { trackDetails -> trackDetails.id == trackId }

    override suspend fun getAllByKeywords(keys: String): List<TrackResponseEntity> =
        listOf()
}