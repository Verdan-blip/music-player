package ru.kpfu.itis.bagaviev.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import ru.kpfu.itis.bagaviev.R
import ru.kpfu.itis.bagaviev.navigation.Navigator
import ru.kpfu.itis.bagaviev.presentation.di.DaggerMainActivityComponent
import ru.kpfu.itis.common.di.connector.deps.ComponentDependenciesProvider
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var navigator: Navigator

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainActivityComponent
            .factory()
            .create(ComponentDependenciesProvider.get(this.applicationContext))
            .inject(this)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fv_container)
                as NavHostFragment

        navController = navHostFragment.navController.also { navigationController ->
            navigator.attachNavController(
                navigationController,
                R.navigation.nav_graph
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        navController?.also(navigator::detachNavController)
    }
}