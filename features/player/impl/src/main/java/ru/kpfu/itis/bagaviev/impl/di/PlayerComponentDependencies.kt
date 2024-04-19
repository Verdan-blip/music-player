package ru.kpfu.itis.bagaviev.impl.di

import android.content.Context
import ru.kpfu.itis.common.di.connector.deps.ComponentDependencies

interface PlayerComponentDependencies : ComponentDependencies {

    fun context(): Context
}