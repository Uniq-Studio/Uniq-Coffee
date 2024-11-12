package org.uniqstudio.uniqcoffee.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Coffee (
    @DrawableRes val imageResourceId: Int,
    @StringRes val titleResourceId: Int,
    @StringRes val descriptionResourceId: Int,
    @StringRes val milkTypeResourceId: Int,
    val price: Double,
    val kcal: Int
)