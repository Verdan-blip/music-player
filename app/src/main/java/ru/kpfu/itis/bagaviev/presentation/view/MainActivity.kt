package ru.kpfu.itis.bagaviev.presentation.view

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import jp.wasabeef.blurry.Blurry
import ru.kpfu.itis.bagaviev.App
import ru.kpfu.itis.bagaviev.R
import ru.kpfu.itis.bagaviev.common.WithAdaptiveBackground
import ru.kpfu.itis.bagaviev.databinding.ActivityMainBinding
import ru.kpfu.itis.bagaviev.navigation.Navigator
import javax.inject.Inject

class MainActivity : AppCompatActivity(), WithAdaptiveBackground {

    @Inject lateinit var navigator: Navigator

    private var viewBinding: ActivityMainBinding? = null

    private var navController: NavController? = null

    override fun updateBackground(drawable: Drawable) {
        viewBinding?.ivBackground?.setImageDrawable(drawable)
        Blurry.with(this)
            .radius(resources.getInteger(ru.kpfu.itis.bagaviev.theme.R.integer.blur_radius))
            .sampling(resources.getInteger(ru.kpfu.itis.bagaviev.theme.R.integer.blur_sampling))
            .capture(viewBinding?.ivBackground)
            .into(viewBinding?.ivBackground)
    }

    private fun setupBottomNavigationView() {
        viewBinding?.apply {
            bnvMain.setOnItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.feedFragment -> navController?.navigate(R.id.feedFragment)
                    R.id.searchFragment -> navController?.navigate(R.id.searchFragment)
                    R.id.profileFragment -> navController?.navigate(R.id.profileFragment)
                }
                true
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding?.root)

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

        setupBottomNavigationView()
    }

    override fun onDestroy() {
        super.onDestroy()
        navController?.also(navigator::detachNavController)
    }
}