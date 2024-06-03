package ru.kpfu.itis.bagaviev.presentation.util

import android.app.Activity
import androidx.fragment.app.Fragment
import ru.kpfu.itis.bagaviev.App


val <T : Activity> T.appComponent
    get() = (applicationContext as App).appComponent

val <T : Fragment> T.appComponent
    get() = requireActivity().appComponent
