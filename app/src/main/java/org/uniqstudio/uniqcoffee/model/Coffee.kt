package org.uniqstudio.uniqcoffee.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

//Coffee model is so that the data source is concise and can be easily changed

data class Coffee(
    @DrawableRes val imageResourceId: Int,
    @StringRes val titleResourceId: Int,
    @StringRes val descriptionResourceId: Int,
    @StringRes val milkTypeResourceId: Int,
    @StringRes val milkDescriptionResourceId: Int,
    val price: Double,
    val kcal: Int
)