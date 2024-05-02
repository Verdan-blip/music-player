package ru.kpfu.itis.bagaviev.navigation

import androidx.navigation.NavController
import ru.kpfu.itis.bagaviev.R
import ru.kpfu.itis.bagaviev.presentation.GlobalRouter

class Navigator : GlobalRouter {

    private var navController: NavController? = null

    fun attachNavController(navController: NavController, graph: Int) {
        navController.setGraph(graph)
        this.navController = navController
    }

    fun detachNavController(navController: NavController) {
        if (this.navController == navController) {
            this.navController = null
        }
    }

    override fun navigateToPlayer() {
        navController?.navigate(R.id.playerFragment)
    }
}