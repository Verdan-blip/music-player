package ru.kpfu.itis.bagaviev.theme.recyclerview.model

import kotlinx.parcelize.Parcelize
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.base.MusicComponentRvModel

@Parcelize
data class SubtitleRvModel(
    val target: Int,
    val text: String
) : MusicComponentRvModel() {

    override fun isSameWith(musicComponentRvModel: MusicComponentRvModel): Boolean {
        return if (musicComponentRvModel is SubtitleRvModel) {
            target == musicComponentRvModel.target
        } else {
            false
        }
    }

    override fun haveSameContentsWith(musicComponentRvModel: MusicComponentRvModel): Boolean {
        return if (musicComponentRvModel is SubtitleRvModel) {
            this == musicComponentRvModel
        } else {
            false
        }
    }
}