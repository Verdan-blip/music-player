package ru.kpfu.itis.bagaviev.presentation.di

import ru.kpfu.itis.bagaviev.navigation.Navigator
import ru.kpfu.itis.bagaviev.presentation.GlobalRouter
import ru.kpfu.itis.common.di.connector.deps.ComponentDependencies

interface MainActivityComponentDependencies : ComponentDependencies {

    val navigator: Navigator

    val globalRouter: GlobalRouter
}