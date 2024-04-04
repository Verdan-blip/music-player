package ru.kpfu.itis.auth.datasources

import android.content.Context
import javax.inject.Inject

class SharedPreferencesDataSource @Inject constructor(
    context: Context?
) : DataSource {

    private val sharedPreferences = context?.getSharedPreferences(
        SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE
    )

    override fun getString(name: String): String? =
        sharedPreferences?.getString(name, null)

    override fun putString(name: String, value: String) {
        sharedPreferences?.apply {
            with (edit()) {
                putString(name, value)
            }
        }
    }

    companion object {
        const val SHARED_PREFERENCES_NAME = "token_store"
    }

}