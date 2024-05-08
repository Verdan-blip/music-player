package ru.kpfu.itis.bagaviev.common.util.delegates

import androidx.fragment.app.Fragment
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class intArgs(private val key: String) : ReadOnlyProperty<Fragment, Int> {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): Int =
        thisRef.arguments?.getInt(key) ?: -1
}