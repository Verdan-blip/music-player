package ru.kpfu.itis.common.util

import androidx.fragment.app.FragmentActivity

interface KnowsActivityLifecycle {

    fun onCreate(activity: FragmentActivity)

    fun onStart()

    fun onStop()

    fun onDestroy()
}