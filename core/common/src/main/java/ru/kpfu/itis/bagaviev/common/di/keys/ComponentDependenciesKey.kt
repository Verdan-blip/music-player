package ru.kpfu.itis.bagaviev.common.di.keys

import dagger.MapKey
import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import kotlin.reflect.KClass

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class ComponentDependenciesKey(val value: KClass<out ComponentDependencies>)