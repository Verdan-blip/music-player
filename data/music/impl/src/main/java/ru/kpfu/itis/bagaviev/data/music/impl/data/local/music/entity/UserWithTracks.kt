package ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class UserWithTracks(

    @Embedded
    var user: UserDbEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(value = TrackUserCrossRef::class)
    )
    var tracks: List<TrackDbEntity>
)