package ru.kpfu.itis.bagaviev.feature.upload.presentation.event

sealed class PickMediaEvent {

    data object SmallCover : PickMediaEvent()

    data object Cover : PickMediaEvent()

    data object Audio : PickMediaEvent()

    data object VideoClip : PickMediaEvent()
}