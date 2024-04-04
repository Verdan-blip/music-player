package ru.kpfu.itis.auth.datasources

interface DataSource {

    fun getString(name: String): String?

    fun putString(name: String, value: String)
}