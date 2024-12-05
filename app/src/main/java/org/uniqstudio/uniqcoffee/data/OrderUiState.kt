package org.uniqstudio.uniqcoffee.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OrderUiState(
    var userName: String = "",
    var currentStamp: Int = 0,
    var totalStamp: Int = 10,

    @StringRes var selectedCoffee: Int = 0,
    var selectedCoffeePrice: Double = 0.0,
    @DrawableRes var selectedCoffeeImage: Int = 0,
    @StringRes var selectedCoffeeDescription: Int = 0,
    @StringRes var selectedCoffeeMilkType: Int = 0,
    var selectedCoffeeKcal: Int = 0,

    var cardNumber: String = "",
    var cardName: String = "",
    var cardExpiry: String = "",
    var cardCvv: String = "",
    )
