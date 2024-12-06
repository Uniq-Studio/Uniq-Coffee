package org.uniqstudio.uniqcoffee.data

import org.uniqstudio.uniqcoffee.R
import org.uniqstudio.uniqcoffee.model.Coffee

//Creating a list of Coffee objects and having them in a list for the following screens can
//pull the data from them

class CoffeeDataSource {
    fun loadCoffee(): List<Coffee> {
        return listOf(
            Coffee(
                imageResourceId = R.drawable.espresso,
                titleResourceId = R.string.espresso,
                descriptionResourceId = R.string.espresso_description,
                milkTypeResourceId = R.string.milk_none,
                milkDescriptionResourceId = 0,
                price = 2.15,
                kcal = 6
            ),
            Coffee(
                imageResourceId = R.drawable.latte,
                titleResourceId = R.string.latte,
                descriptionResourceId = R.string.latte_description,
                milkTypeResourceId = R.string.milk_semi,
                milkDescriptionResourceId = R.string.milk_semi_description,
                price = 3.55,
                kcal = 153
            ),
            Coffee(
                imageResourceId = R.drawable.cappuccino,
                titleResourceId = R.string.cappuccino,
                descriptionResourceId = R.string.cappuccino_description,
                milkTypeResourceId = R.string.milk_semi,
                milkDescriptionResourceId = R.string.milk_semi_description,
                price = 3.55,
                kcal = 156
            ),
            Coffee(
                imageResourceId = R.drawable.flat_white,
                titleResourceId = R.string.flat_white,
                descriptionResourceId = R.string.flat_white_description,
                milkTypeResourceId = R.string.milk_whole,
                milkDescriptionResourceId = R.string.milk_whole_description,
                price = 3.65,
                kcal = 195
            ),
            Coffee(
                imageResourceId = R.drawable.americano,
                titleResourceId = R.string.americano,
                descriptionResourceId = R.string.americano_description,
                milkTypeResourceId = R.string.milk_none,
                milkDescriptionResourceId = 0,
                price = 2.55,
                kcal = 22
            ),
            Coffee(
                imageResourceId = R.drawable.macchiato,
                titleResourceId = R.string.macchiato,
                descriptionResourceId = R.string.macchiato_description,
                milkTypeResourceId = R.string.milk_semi,
                milkDescriptionResourceId = R.string.milk_semi_description,
                price = 3.05,
                kcal = 10
            ),
            Coffee(
                imageResourceId = R.drawable.mocha,
                titleResourceId = R.string.mocha,
                descriptionResourceId = R.string.mocha_description,
                milkTypeResourceId = R.string.milk_whole,
                milkDescriptionResourceId = R.string.milk_whole_description,
                price = 2.55,
                kcal = 15
            ),

            Coffee(
                imageResourceId = R.drawable.hot_chocolate,
                titleResourceId = R.string.hot_chocolate,
                descriptionResourceId = R.string.hot_chocolate_description,
                milkTypeResourceId = R.string.milk_whole,
                milkDescriptionResourceId = R.string.milk_whole_description,
                price = 3.65,
                kcal = 362
            ),
            Coffee(
                imageResourceId = R.drawable.tea,
                titleResourceId = R.string.tea,
                descriptionResourceId = R.string.tea_description,
                milkTypeResourceId = R.string.milk_none,
                milkDescriptionResourceId = 0,
                price = 2.45,
                kcal = 10
            ),
            Coffee(
                imageResourceId = R.drawable.decaf_tea,
                titleResourceId = R.string.decaf_tea,
                descriptionResourceId = R.string.decaf_tea_description,
                milkTypeResourceId = R.string.milk_none,
                milkDescriptionResourceId = 0,
                price = 2.45,
                kcal = 10
            )
        )


    }
}