package ru.kpfu.itis.bagaviev.theme.recyclerview.model

import kotlinx.parcelize.Parcelize
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.base.MusicComponentRvModel

@Parcelize
data class PlaylistRvModel(
    val id: Long,
    val title: String,
    val coverUri: String
) : MusicComponentRvModel() {

    override fun isSameWith(musicComponentRvModel: MusicComponentRvModel): Boolean {
        return if (musicComponentRvModel is PlaylistRvModel) {
            id == musicComponentRvModel.id
        } else {
            false
        }
    }

    override fun haveSameContentsWith(musicComponentRvModel: MusicComponentRvModel): Boolean {
        return if (musicComponentRvModel is PlaylistRvModel) {
            this == musicComponentRvModel
        } else {
            false
        }
    }
}