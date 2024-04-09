package ru.kpfu.itis.bagaviev.player.di

import android.content.Context
import ru.kpfu.itis.common.di.connector.deps.ComponentDependencies

interface PlayerComponentDependencies : ComponentDependencies {

    fun getContext(): Context
}