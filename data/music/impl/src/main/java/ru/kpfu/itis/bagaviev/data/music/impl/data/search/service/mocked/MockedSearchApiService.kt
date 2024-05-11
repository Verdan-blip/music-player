package ru.kpfu.itis.bagaviev.data.music.impl.data.search.service.mocked

import ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.pojo.responses.PlaylistResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.service.mocked.MockedPlaylistApiService
import ru.kpfu.itis.bagaviev.data.music.impl.data.search.pojo.responses.SearchResultResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.search.service.SearchApiService
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.pojo.responses.TrackResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.service.mocked.MockedTrackApiService
import javax.inject.Inject

class MockedSearchApiService @Inject constructor(
    private val playlistApiService: MockedPlaylistApiService,
    private val trackApiService: MockedTrackApiService
) : SearchApiService {

    override fun search(keywords: String, limit: Int, offset: Int): SearchResultResponse {
        val playlists = playlistApiService.popularPlaylists
        val tracks = trackApiService.chartTracksList

        val foundTracks = mutableListOf<TrackResponse>()
        val foundPlaylists = mutableListOf<PlaylistResponse>()

        val keys = keywords.split("+")
        for (key in keys) {
            for (trackToMatch in tracks) {
                if (trackToMatch.title.lowercase().contains(key.lowercase()))
                    foundTracks.add(trackToMatch)
            }
            for (playlistToMatch in playlists) {
                if (playlistToMatch.title.lowercase().contains(key.lowercase()))
                    foundPlaylists.add(playlistToMatch)
            }
        }
        return SearchResultResponse(
            users = listOf(),
            tracks = foundTracks,
            playlists = foundPlaylists
        )
    }
}