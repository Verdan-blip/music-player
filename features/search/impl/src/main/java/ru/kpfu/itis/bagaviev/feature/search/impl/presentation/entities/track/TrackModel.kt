package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track

data class TrackModel(
    val id: Long,
    val title: String,
    val smallCoverUri: String,
    val authorNames: List<String>
)