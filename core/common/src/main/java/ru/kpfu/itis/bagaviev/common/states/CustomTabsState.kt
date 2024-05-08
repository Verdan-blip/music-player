package ru.kpfu.itis.bagaviev.common.states

import android.net.Uri

sealed interface CustomTabsState {

    data object NoAction : CustomTabsState

    data class Opened(val uri: Uri) : CustomTabsState

    data object Closed : CustomTabsState
}