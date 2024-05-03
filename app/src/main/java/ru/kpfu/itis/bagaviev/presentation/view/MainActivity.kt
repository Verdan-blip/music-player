package ru.kpfu.itis.bagaviev.presentation.view

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ru.kpfu.itis.bagaviev.App
import ru.kpfu.itis.bagaviev.R
import ru.kpfu.itis.bagaviev.navigation.Navigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var navigator: Navigator

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent
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