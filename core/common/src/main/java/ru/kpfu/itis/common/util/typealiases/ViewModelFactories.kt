package ru.kpfu.itis.common.util.typealiases

import androidx.lifecycle.ViewModel
import javax.inject.Provider

typealias ViewModelFactories = Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>