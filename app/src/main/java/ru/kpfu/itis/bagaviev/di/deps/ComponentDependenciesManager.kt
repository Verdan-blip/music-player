package ru.kpfu.itis.bagaviev.di.deps

import ru.kpfu.itis.common.di.connector.deps.ComponentDependencies
import javax.inject.Inject
import kotlin.reflect.KClass

typealias DependenciesMap = Map<
        Class<out ComponentDependencies>,
        ComponentDependencies>

class ComponentDependenciesManager @Inject constructor(
    private val dependenciesMap: DependenciesMap
) {

    @Suppress("UNCHECKED_CAST")
    fun <T : ComponentDependencies> getDependencies(key: Class<T>): T =
        (dependenciesMap[key] as? T)
            ?: throw IllegalStateException("Missing dependencies for key $key")
}