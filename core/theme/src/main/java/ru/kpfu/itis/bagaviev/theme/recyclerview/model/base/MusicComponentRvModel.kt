package ru.kpfu.itis.bagaviev.theme.recyclerview.model.base

import android.os.Parcelable

abstract class MusicComponentRvModel : Parcelable {

    abstract fun isSameWith(musicComponentRvModel: MusicComponentRvModel): Boolean

    abstract fun haveSameContentsWith(musicComponentRvModel: MusicComponentRvModel): Boolean
}