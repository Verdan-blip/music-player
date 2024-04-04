package ru.kpfu.itis.common.di.connector.containers

import ru.kpfu.itis.common.di.connector.deps.ComponentDependencies
import kotlin.reflect.KClass

interface DependenciesContainer {
    fun <T : ComponentDependencies> getDeps(key: Class<T>): T
}