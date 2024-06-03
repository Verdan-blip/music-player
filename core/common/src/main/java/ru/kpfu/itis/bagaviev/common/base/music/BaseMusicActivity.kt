package ru.kpfu.itis.bagaviev.common.base.music

import androidx.appcompat.app.AppCompatActivity

abstract class BaseMusicActivity : AppCompatActivity() {

    abstract val musicViewModel: BaseMusicViewModel
}