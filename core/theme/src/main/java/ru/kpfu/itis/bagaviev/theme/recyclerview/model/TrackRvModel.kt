package ru.kpfu.itis.bagaviev.theme.recyclerview.model

import kotlinx.parcelize.Parcelize
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.base.MusicComponentRvModel

@Parcelize
data class TrackRvModel(
    val id: Long,
    val title: String,
    val smallCoverUri: String,
    val authorNames: List<String>
) : MusicComponentRvModel() {

    override fun isSameWith(musicComponentRvModel: MusicComponentRvModel): Boolean {
        return if (musicComponentRvModel is TrackRvModel) {
            id == musicComponentRvModel.id
        } else {
            false
        }
    }

    override fun haveSameContentsWith(musicComponentRvModel: MusicComponentRvModel): Boolean {
        return if (musicComponentRvModel is TrackRvModel) {
            this == musicComponentRvModel
        } else {
            false
        }
    }
}