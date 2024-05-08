package ru.kpfu.itis.bagaviev.common.di.connector.containers

import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies

interface DependenciesContainer {
    fun <T : ComponentDependencies> getDeps(key: Class<T>): T
}