package ru.kpfu.itis.bagaviev.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val _errorAlert = MutableSharedFlow<String>()

    val errorAlert: SharedFlow<String>
        get() = _errorAlert

    protected fun showAlert(message: String) {
        viewModelScope.launch {
            _errorAlert.emit(message)
        }
    }
}