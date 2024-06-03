package ru.kpfu.itis.bagaviev.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import ru.kpfu.itis.bagaviev.common.util.typealiases.ViewModelFactories
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    abstract val coroutineDispatcher: CoroutineDispatcher


    private val _errorAlert = MutableSharedFlow<String>()
    val errorAlert: SharedFlow<String>
        get() = _errorAlert


    protected fun showAlert(message: String) {
        viewModelScope.launch(coroutineDispatcher) {
            _errorAlert.emit(message)
        }
    }


    companion object {

        class Factory @Inject constructor(
            private val viewModelFactories: ViewModelFactories
        ) : ViewModelProvider.Factory {

            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return viewModelFactories.getValue(modelClass).get() as T
            }
        }
    }
}