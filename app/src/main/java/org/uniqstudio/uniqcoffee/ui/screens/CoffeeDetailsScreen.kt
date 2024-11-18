package org.uniqstudio.uniqcoffee.ui.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.uniqstudio.uniqcoffee.R

@Composable
fun CoffeeDetailsScreen(
    @StringRes title: Int,
    price: Double,
    @DrawableRes image: Int,
    @StringRes description: Int,
    @StringRes milkType: Int,
    kcal: Int
){
    Column() {
        HeaderText(title)
        Text("$$price")
        Image(painter = painterResource(image), contentDescription = stringResource(title))
        DescriptionText(description)
        HiddenDetailsBox(
            true,
            onClick = {},
            R.string.milk_type,
            milkType,
            false,
            R.string.milk_semi
        )
        HiddenDetailsBox(
            true,
            {},
            R.string.kcal,
            kcal,
            true,
            R.string.kcal_info
        )
    }


}

@Preview
@Composable
fun CoffeeDetailsScreenPreview(){
        CoffeeDetailsScreen(
            R.string.espresso,
            2.99,
            R.drawable.espresso,
            R.string.espresso_description,
            R.string.milk_semi,
            95
        )
}

