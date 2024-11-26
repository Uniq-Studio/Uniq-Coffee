package org.uniqstudio.uniqcoffee.ui.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.uniqstudio.uniqcoffee.R

@Composable
fun HomeScreenApp(
    //Header Variables
    @StringRes welcomeBackText: Int,
    @StringRes userNameText: Int,

    //Stamp Card Variables
    currentStamp: Int,
    totalStamp: Int,

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
        ) {
            HeaderText(welcomeBackText)
            HeaderText(userNameText)
            Spacer(modifier = Modifier.size(10.dp))
            StampCard(currentStamp, totalStamp)
            Spacer(modifier = Modifier.size(20.dp))
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
    Column() {
        Row {
            Text(
                text = stringResource(R.string.stamp_card)
            )
            Text(
                text = "$currentStamp/$totalStamp"
            )
        }

        LinearProgressIndicator(
            progress = { currentStamp.toFloat() / totalStamp.toFloat() },
        )
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
        Spacer(modifier = Modifier.size(10.dp))
        CoffeeButton(buttonTwoImage, buttonTwoText, buttonTwoOnClick)
    }
}

@Preview
@Composable
fun CoffeeScreenPreview() {
    HomeScreenApp(
        R.string.welcome_back,
        R.string.user_name_temp,

        3,
        10,

        R.drawable.coffee_bean,
        R.string.settings,
        {},

        R.drawable.coffee_bean,
        R.string.order,
        {}
    )
}