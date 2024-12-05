package org.uniqstudio.uniqcoffee.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.uniqstudio.uniqcoffee.R

data class OrderUiState(
    var userName: String = "",
    var currentStamp: Int = 0,
    var totalStamp: Int = 10,

    @StringRes var selectedCoffee: Int = R.string.latte,
    var selectedCoffeePrice: Double = 3.65,
    @DrawableRes var selectedCoffeeImage: Int = R.drawable.latte,
    @StringRes var selectedCoffeeDescription: Int = R.string.latte_description,
    @StringRes var selectedCoffeeMilkType: Int = R.string.milk_semi,
    var selectedCoffeeKcal: Int = 365,

    var cardNumber: String = "1234567891234567",
    var cardName: String = "Mr Example U Text",
    var cardExpiry: String = "01/26",
    var cardCvv: String = "334",
    )
