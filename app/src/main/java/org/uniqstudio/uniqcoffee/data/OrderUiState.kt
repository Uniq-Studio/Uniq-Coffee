package org.uniqstudio.uniqcoffee.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OrderUiState(
    var FTSUCompleted: Boolean = false,

    var userName: String = "Aaron",
    var currentStamp: Int = 9,
    var totalStamp: Int = 10,
    var freeCoffees: Int = 0,

    @StringRes var selectedCoffee: Int = 0,
    var selectedCoffeePrice: Double = 0.0,
    @DrawableRes var selectedCoffeeImage: Int = 0,
    @StringRes var selectedCoffeeDescription: Int = 0,
    @StringRes var selectedCoffeeMilkType: Int = 0,
    var selectedCoffeeKcal: Int = 0,

    var cardNumber: String = "1234567890123456",
    var cardName: String = "Mr Uniq C Studio",
    var cardExpiry: String = "12/26",
    var cardCvv: String = "009",
    )
