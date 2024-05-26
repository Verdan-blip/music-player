package ru.kpfu.itis.bagaviev.theme.recyclerview.model

import kotlinx.parcelize.Parcelize
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.base.MusicComponentRvModel

@Parcelize
data class PlaylistGroupRvModel(
    val id: Int,
    val playlists: List<PlaylistRvModel>
) : MusicComponentRvModel() {

    override fun isSameWith(musicComponentRvModel: MusicComponentRvModel): Boolean {
        return if (musicComponentRvModel is PlaylistGroupRvModel) {
            id == musicComponentRvModel.id
        } else {
            false
        }
    }

    override fun haveSameContentsWith(musicComponentRvModel: MusicComponentRvModel): Boolean {
        return if (musicComponentRvModel is PlaylistGroupRvModel) {
            this == musicComponentRvModel
        } else {
            false
        }
    }
}