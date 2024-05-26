package ru.kpfu.itis.bagaviev.theme.recyclerview.model

import kotlinx.parcelize.Parcelize
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.base.MusicComponentRvModel

@Parcelize
data class AuthorRvModel(
    val id: Long,
    val login: String,
    val avatarUri: String?
) : MusicComponentRvModel() {

    override fun isSameWith(musicComponentRvModel: MusicComponentRvModel): Boolean {
        return if (musicComponentRvModel is AuthorRvModel) {
            id == musicComponentRvModel.id
        } else {
            false
        }
    }

    override fun haveSameContentsWith(musicComponentRvModel: MusicComponentRvModel): Boolean {
        return if (musicComponentRvModel is AuthorRvModel) {
            this == musicComponentRvModel
        } else {
            false
        }
    }
}