package org.uniqstudio.uniqcoffee.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

//This data class stores the order data so they are not processed with every screen change
//and other screen can pull and push data with a ViewModel

data class OrderUiState(
    //Display First Time Setup Screen and once complete wont display again
    var FTSUCompleted: Boolean = false,

    //User data
    //Variable that stores the user name, and coffee they gain
    var userName: String = "Aaron",
    var currentStamp: Int = 9,
    var totalStamp: Int = 10,
    var freeCoffees: Int = 0,

    //Selected Coffee Data
    @StringRes var selectedCoffee: Int = 0,
    var selectedCoffeePrice: Double = 0.0,
    @DrawableRes var selectedCoffeeImage: Int = 0,
    @StringRes var selectedCoffeeDescription: Int = 0,
    @StringRes var selectedCoffeeMilkType: Int = 0,
    @StringRes var selectedCoffeeMilkTypeDescription: Int = 0,
    var selectedCoffeeKcal: Int = 0,

    //Fake Credit card information
    var cardNumber: String = "1234567890123456",
    var cardName: String = "Mr Uniq C Studio",
    var cardExpiry: String = "12/26",
    var cardCvv: String = "009",
)
