package org.uniqstudio.uniqcoffee.data

import org.uniqstudio.uniqcoffee.R
import org.uniqstudio.uniqcoffee.model.Coffee

class CoffeeDataSource {
    fun loadCoffee(): List<Coffee> {
        return listOf(
            Coffee(
                imageResourceId = R.drawable.espresso,
                titleResourceId = R.string.espresso,
                descriptionResourceId = R.string.espresso_description,
                milkTypeResourceId = R.string.milk_none,
                price = 2.50,
                kcal = 100
            ),
            Coffee(
                imageResourceId = R.drawable.latte,
                titleResourceId = R.string.latte,
                descriptionResourceId = R.string.latte_description,
                milkTypeResourceId = R.string.milk_semi,
                price = 3.00,
                kcal = 150
            ),
            Coffee(
                imageResourceId = R.drawable.cappuccino,
                titleResourceId = R.string.cappuccino,
                descriptionResourceId = R.string.cappuccino_description,
                milkTypeResourceId = R.string.milk_skimmed,
                price = 3.50,
                kcal = 200
            ),
            Coffee(
                imageResourceId = R.drawable.flat_white,
                titleResourceId = R.string.flat_white,
                descriptionResourceId = R.string.flat_white_description,
                milkTypeResourceId = R.string.milk_semi,
                price = 3.00,
                kcal = 150
            ),
            Coffee(
                imageResourceId = R.drawable.americano,
                titleResourceId = R.string.americano,
                descriptionResourceId = R.string.americano_description,
                milkTypeResourceId = R.string.milk_none,
                price = 2.50,
                kcal = 100
            ),
            Coffee(
                imageResourceId = R.drawable.macchiato,
                titleResourceId = R.string.macchiato,
                descriptionResourceId = R.string.macchiato_description,
                milkTypeResourceId = R.string.milk_semi,
                price = 3.00,
                kcal = 150
            ),
            Coffee(
                imageResourceId = R.drawable.mocha,
                titleResourceId = R.string.mocha,
                descriptionResourceId = R.string.mocha_description,
                milkTypeResourceId = R.string.milk_whole,
                price = 3.50,
                kcal = 200
            ),

            Coffee(
                imageResourceId = R.drawable.hot_chocolate,
                titleResourceId = R.string.hot_chocolate,
                descriptionResourceId = R.string.hot_chocolate_description,
                milkTypeResourceId = R.string.milk_whole,
                price = 3.50,
                kcal = 200
            ),
            Coffee(
                imageResourceId = R.drawable.tea,
                titleResourceId = R.string.tea,
                descriptionResourceId = R.string.tea_description,
                milkTypeResourceId = R.string.milk_none,
                price = 2.50,
                kcal = 100
            ),
            Coffee(
                imageResourceId = R.drawable.decaf_tea,
                titleResourceId = R.string.decaf_tea,
                descriptionResourceId = R.string.decaf_tea_description,
                milkTypeResourceId = R.string.milk_none,
                price = 2.50,
                kcal = 100
            )
            )




    }
}