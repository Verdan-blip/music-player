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
        navController?.navigate(R.id.action_feedFragment_to_playerFragment)
    }

    override fun navigateToProfile() {
        navController?.navigate(R.id.profileFragment)
    }

    override fun navigateToSignIn() {
        navController?.navigate(R.id.signInFragment)
    }

    override fun navigateToSignUp() {
        navController?.navigate(R.id.signUpFragment)
    }
}