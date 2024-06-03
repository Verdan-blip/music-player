package ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.entity

import kotlinx.parcelize.Parcelize
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.base.MusicComponentRvModel

@Parcelize
class AuthorPlaceholderRvModel : MusicComponentRvModel() {


    override fun isSameWith(musicComponentRvModel: MusicComponentRvModel): Boolean =
        musicComponentRvModel is AuthorPlaceholderRvModel

    override fun haveSameContentsWith(musicComponentRvModel: MusicComponentRvModel): Boolean =
        musicComponentRvModel is AuthorPlaceholderRvModel
}