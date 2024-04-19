package ru.kpfu.itis.common.util.delegates

import androidx.fragment.app.Fragment
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class stringArgs(private val key: String) : ReadOnlyProperty<Fragment, String> {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): String =
        thisRef.arguments?.getString(key) ?: ""
}