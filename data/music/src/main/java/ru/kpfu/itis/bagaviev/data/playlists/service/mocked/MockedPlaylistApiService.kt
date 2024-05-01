package ru.kpfu.itis.bagaviev.data.playlists.service.mocked

import ru.kpfu.itis.bagaviev.data.playlists.entities.responses.PlaylistDetailsResponseEntity
import ru.kpfu.itis.bagaviev.data.playlists.entities.responses.PlaylistResponseEntity
import ru.kpfu.itis.bagaviev.data.playlists.service.PlaylistApiService
import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackResponseEntity
import ru.kpfu.itis.bagaviev.data.users.entites.responses.UserResponseEntity

class MockedPlaylistApiService : PlaylistApiService {

    private val playlistDetails = listOf(
        PlaylistDetailsResponseEntity(
            id = 0,
            title = "Нескончаемые Дожди",
            coverUri = "https://cdns-images.dzcdn.net/images/cover/bbc9b2e880c9f522e8c8767f49fb9fab/264x264.jpg",
            user = UserResponseEntity(id = 0, "Три дня дождя"),
            tracks = listOf(
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
            ),
            createdDate = "2024-04-30",
            playsCount = 123
        ),
        PlaylistDetailsResponseEntity(
            id = 1,
            title = "Не придумал",
            coverUri = "https://upload.wikimedia.org/wikipedia/ru/2/2f/Billie_Eilish_-_Don%27t_Smile_at_Me.png",
            user = UserResponseEntity(id = 1, login = "Billie Eilish"),
            tracks = listOf(
                TrackResponseEntity(
                    id = 2,
                    title = "Bad guy",
                    users = listOf(UserResponseEntity(1, "Billie Eilish")),
                    smallCoverUri = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaYxW05-O5D1LMMBz_ldqrgXLGIKq2eggGGOEqhYQwzQ&s"
                ),
            ),
            createdDate = "2024.04.30",
            playsCount = 20
        ),
    )

    private val popularPlaylists = listOf(
        PlaylistResponseEntity(
            id = 0,
            title = "Нескончаемые Дожди",
            coverUri = "https://cdns-images.dzcdn.net/images/cover/bbc9b2e880c9f522e8c8767f49fb9fab/264x264.jpg",
            user = UserResponseEntity(id = 0, "Три дня дождя"),
            tracks = listOf(
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
            )
        ),
        PlaylistResponseEntity(
            id = 1,
            title = "Не придумал",
            coverUri = "https://upload.wikimedia.org/wikipedia/ru/2/2f/Billie_Eilish_-_Don%27t_Smile_at_Me.png",
            user = UserResponseEntity(id = 1, login = "Billie Eilish"),
            tracks = listOf(
                TrackResponseEntity(
                    id = 2,
                    title = "Bad guy",
                    users = listOf(UserResponseEntity(1, "Billie Eilish")),
                    smallCoverUri = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaYxW05-O5D1LMMBz_ldqrgXLGIKq2eggGGOEqhYQwzQ&s"
                ),
            )
        )
    )

    override suspend fun getById(trackId: Long): PlaylistDetailsResponseEntity? =
        playlistDetails.firstOrNull { playlistDetails ->
            playlistDetails.id == trackId
        }

    override suspend fun getPopularPlaylists(
        limit: Int,
        offset: Int
    ): List<PlaylistResponseEntity> =
        popularPlaylists

    override suspend fun getAllByKeywords(keys: String): List<PlaylistResponseEntity> =
        listOf()
}