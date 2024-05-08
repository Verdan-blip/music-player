package ru.kpfu.itis.bagaviev.common.di.connector.deps

import android.content.Context
import ru.kpfu.itis.bagaviev.common.di.connector.containers.DependenciesContainer
import java.lang.IllegalStateException

object ComponentDependenciesProvider {

    inline fun <reified T : ComponentDependencies> get(context: Context): T =
        (context.applicationContext as? DependenciesContainer)?.getDeps(T::class.java)
            ?: throw IllegalStateException("App didn't provide dependencies")
}