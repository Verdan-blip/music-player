package ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "users_tracks",
    foreignKeys = [
        ForeignKey(
            entity = UserDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
        ),
        ForeignKey(
            entity = DownloadedTrackDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["track_id"]
        )
    ]
)
class TrackUserCrossRef(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "user_id")
    val userId: Long,

    @ColumnInfo(name = "track_id")
    val trackId: Long,
)