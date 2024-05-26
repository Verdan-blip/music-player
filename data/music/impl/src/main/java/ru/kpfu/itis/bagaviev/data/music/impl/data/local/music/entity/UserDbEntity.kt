package ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserDbEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "login")
    val login: String,

    @ColumnInfo(name = "avatar_uri")
    val avatarUri: String
)