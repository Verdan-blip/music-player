package ru.kpfu.itis.bagaviev.navigation

import androidx.navigation.NavController
import ru.kpfu.itis.bagaviev.R
import ru.kpfu.itis.bagaviev.presentation.GlobalRouter

class Navigator : GlobalRouter {

    private var rootNavController: NavController? = null

    private var navController: NavController? = null

    fun attachNavController(navController: NavController) {
        this.navController = navController
    }

    fun attachRootNavController(navController: NavController) {
        this.rootNavController = navController
    }

    fun detachNavController(navController: NavController) {
        if (this.navController == navController) {
            this.navController = null
        }
    }

    fun detachRootNavController(navController: NavController) {
        if (this.rootNavController == navController) {
            this.rootNavController = null
        }
    }

    override fun navigateToPlayer() {
        rootNavController?.navigate(R.id.playerFragment)
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

    override fun navigateToUpload() {
        navController?.navigate(R.id.uploadFragment)
    }
}