package org.uniqstudio.uniqcoffee.ui.screens

import android.util.EventLogTags
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.uniqstudio.uniqcoffee.R

@Composable
fun HeaderText(@StringRes text: Int) {
    Text(
        text = stringResource(text)
    )
}

@Composable
fun DescriptionText(@StringRes text: Int) {
    Text(
        text = stringResource(text)
    )
}

@Composable
fun CoffeeButton(
    @DrawableRes image: Int,
    @StringRes text: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FilledTonalButton(
        onClick = onClick,
        shape = MaterialTheme.shapes.extraSmall
    ) {
        Column() {
            Image(
                painter = painterResource(image),
                contentDescription = stringResource(text),
                modifier = modifier.size(100.dp)
            )
            Text(
                text = stringResource(text)
            )
        }

    }
}

@Composable
fun HiddenDetailsBox(
    expanded: Boolean = false,
    onClick: () -> Unit = {},
    @StringRes title: Int,
    @StringRes type: Int,
    justNumbers: Boolean,
    @StringRes description: Int
){
    Card() {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
                Row()
                {
                    Text(stringResource(title))
                    if (!justNumbers){
                    Text(stringResource(type))
                    } else {
                        Text("$type")
                    }

                    if (expanded) {
                        Icon(Icons.Filled.KeyboardArrowUp, contentDescription = null, modifier = Modifier.clickable( onClick = {!expanded}))
                    } else {
                        Icon(Icons.Filled.KeyboardArrowDown, contentDescription = null, modifier = Modifier.clickable( onClick = {!expanded}))
                    }
                }

                if (expanded) {
                    Text(stringResource(description))

                }
            }
        }
    }

@Composable
fun BottomBarButton(@StringRes text: Int, onClick: () -> Unit){
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        FilledTonalButton(
            onClick = onClick,
            shape = MaterialTheme.shapes.extraSmall,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(stringResource(text))
        }
    }
}


@Preview
@Composable
fun HeaderTextPreview(){
    HeaderText(R.string.welcome_back)
}

@Preview
@Composable
fun DescriptionTextPreview(){
    HeaderText(R.string.espresso_description)
}

@Preview
@Composable
fun CoffeeButtonPreview(){
    CoffeeButton(R.drawable.espresso, R.string.espresso, {})
}

@Preview
@Composable
fun HiddenDetailsBoxPreview(){
    HiddenDetailsBox(true, {}, R.string.milk_type, R.string.milk_semi, false, R.string.milk_semi)
}

@Preview
@Composable
fun BottomBarButtonPreview(){
    BottomBarButton(R.string.add_to_cart, {})
}