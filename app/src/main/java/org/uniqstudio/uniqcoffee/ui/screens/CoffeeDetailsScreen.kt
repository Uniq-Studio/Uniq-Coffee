package org.uniqstudio.uniqcoffee.ui.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.uniqstudio.uniqcoffee.R

//This screen gives the user more details about the coffee they selected.
//It also has a button to add the coffee to the cart.
//It also has drop down boxes to show the details of the coffee.

@Composable
fun CoffeeDetailsScreen(
    @StringRes title: Int,
    price: Double,

    @DrawableRes image: Int,

    @StringRes description: Int,

    @StringRes milkType: Int,
    @StringRes milkDescription: Int,
    kcal: Int,

    onClickAdd: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
            .verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HeaderText(
                text = title,
                bold = true,
                size = 60
            )

            Text(
                "$$price",
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.padding(20.dp))

            Image(painter = painterResource(image), contentDescription = stringResource(title))
            DescriptionText(description)

            HiddenDetailsBox(
                title = R.string.milk_type,
                type = milkType,
                justNumbers = false,
                description = milkDescription
            )
            HiddenDetailsBox(
                title = R.string.kcal,
                type = kcal,
                justNumbers = true,
                description = R.string.kcal_info
            )
            Spacer(modifier = Modifier.padding(20.dp))

        }
    }
    BottomBarButton(
        text = R.string.add_to_cart,
        onClick = onClickAdd
    )
}

@Preview
@Composable
fun CoffeeDetailsScreenPreview() {
    CoffeeDetailsScreen(
        R.string.espresso,
        2.99,
        R.drawable.espresso,
        R.string.espresso_description,
        R.string.milk_semi,
        R.string.milk_semi_description,
        95,
        {}
    )
}

