package org.uniqstudio.uniqcoffee.ui.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.uniqstudio.uniqcoffee.R

@Composable
fun HomeScreenApp(
    //Header Variables
    @StringRes welcomeBackText: Int,
    userNameText: String,


    //Stamp Card Variables
    currentStamp: Int,
    totalStamp: Int,
    freeCoffees: Int,

    //Button Variables
    @DrawableRes coffeeSettingImage: Int,
    @StringRes coffeeSettingText: Int,
    coffeeSettingOnClick: () -> Unit,

    @DrawableRes coffeeBeanImage: Int,
    @StringRes StartOrderText: Int,
    StartOrderOnClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column {
                HeaderText(welcomeBackText, false, 55)
                HeaderText(userNameText, true, 50)

            }
            Spacer(modifier = Modifier.size(100.dp))
            StampCard(currentStamp, totalStamp)
            if (freeCoffees > 0) {
                TextBoxed(R.string.free_coffee, true, 15)
            }
            Spacer(modifier = Modifier.size(100.dp))
            ButtonArray(
                coffeeSettingImage,
                coffeeSettingText,
                coffeeSettingOnClick,
                coffeeBeanImage,
                StartOrderText,
                StartOrderOnClick
            )
        }
    }
}

@Composable
fun StampCard(currentStamp: Int, totalStamp: Int) {
    Column(
        modifier = Modifier
            .width(375.dp)
            .background(androidx.compose.ui.graphics.Color.White)
    ) {
        Row {
            Spacer(modifier = Modifier.size(10.dp))
            TextBoxed(R.string.stamp_card, true, 20)

            Spacer(
                modifier = Modifier
                    .size(10.dp)
                    .weight(1f)
            )

            Text(
                text = "$currentStamp/$totalStamp",
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.size(10.dp))

        }

        Spacer(modifier = Modifier.size(10.dp))

        LinearProgressIndicator(
            progress = { currentStamp.toFloat() / totalStamp.toFloat() },
            modifier = Modifier
                .heightIn(50.dp)
                .fillMaxWidth()
                .padding(10.dp)
        )


        Spacer(modifier = Modifier.size(10.dp))
    }
}

@Composable
fun ButtonArray(
    @DrawableRes buttonOneImage: Int,
    @StringRes buttonOneText: Int,
    buttonOneOnClick: () -> Unit,

    @DrawableRes buttonTwoImage: Int,
    @StringRes buttonTwoText: Int,
    buttonTwoOnClick: () -> Unit,
) {
    Row {
        CoffeeButton(buttonOneImage, buttonOneText, buttonOneOnClick)
        Spacer(modifier = Modifier.size(50.dp))
        CoffeeButton(buttonTwoImage, buttonTwoText, buttonTwoOnClick)
    }
}

@Preview
@Composable
fun CoffeeScreenPreview() {
    HomeScreenApp(
        R.string.welcome_back,
        "Aaron",

        3,
        10,
        1,

        R.drawable.settings,
        R.string.settings,
        {},

        R.drawable.coffee_bean,
        R.string.order,
        {},
    )
}
