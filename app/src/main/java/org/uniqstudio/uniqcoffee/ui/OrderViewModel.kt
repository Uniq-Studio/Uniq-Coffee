package org.uniqstudio.uniqcoffee.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.uniqstudio.uniqcoffee.data.OrderUiState

class OrderViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    fun updateUserName(newUserName: String) {
        _uiState.value = _uiState.value.copy(userName = newUserName)
    }

    fun updateCurrentStamp(newCurrentStamp: Int) {
        _uiState.value = _uiState.value.copy(currentStamp = newCurrentStamp)
    }

}