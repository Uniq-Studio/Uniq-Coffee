package org.uniqstudio.uniqcoffee.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
        if (_uiState.value.currentStamp >= _uiState.value.totalStamp) {
            _uiState.value =
                _uiState.value.copy(currentStamp = _uiState.value.currentStamp - _uiState.value.totalStamp)
            gainFreeCoffee()
        }
    }

    fun gainFreeCoffee() {
        _uiState.value = _uiState.value.copy(freeCoffees = _uiState.value.freeCoffees + 1)
    }

    fun useFreeCoffee() {
        _uiState.value = _uiState.value.copy(freeCoffees = _uiState.value.freeCoffees - 1)
    }

    fun firstTimeSetUpComplete() {
        _uiState.value = _uiState.value.copy(FTSUCompleted = true)
    }

    fun updateCoffeeSelectionScreen(
        @StringRes selectedCoffee: Int,
        price: Double,
        @DrawableRes image: Int,
        @StringRes description: Int,
        @StringRes milkType: Int,
        @StringRes milkDescription: Int,
        kcal: Int
    ) {
        _uiState.value = _uiState.value.copy(
            selectedCoffee = selectedCoffee,
            selectedCoffeePrice = price,
            selectedCoffeeImage = image,
            selectedCoffeeDescription = description,
            selectedCoffeeMilkType = milkType,
            selectedCoffeeMilkTypeDescription = milkDescription,
            selectedCoffeeKcal = kcal
        )
    }

    fun updateCardDetails(
        cardNumber: String,
        cardName: String,
        cardExpiry: String,
        cardCvv: String
    ) {
        _uiState.value = _uiState.value.copy(
            cardNumber = cardNumber,
            cardName = cardName,
            cardExpiry = cardExpiry,
            cardCvv = cardCvv
        )

    }

}