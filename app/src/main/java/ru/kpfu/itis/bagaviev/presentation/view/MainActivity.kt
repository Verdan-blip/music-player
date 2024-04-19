package ru.kpfu.itis.bagaviev.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.kpfu.itis.bagaviev.R
import ru.kpfu.itis.bagaviev.impl.presentation.view.PlayerFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fv_container,
                PlayerFragment())
            .commit()
    }
}