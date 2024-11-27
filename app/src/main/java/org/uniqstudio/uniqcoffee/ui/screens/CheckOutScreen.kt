package org.uniqstudio.uniqcoffee.ui.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SelectedCoffeeCard(@DrawableRes image: Int, @StringRes title: Int, @StringRes description: Int, price: Double, onClick: () -> Unit) {
    Column() {
        Card() {
            Row() {
                Image(
                    painter = painterResource(image),
                    contentDescription = stringResource(title),
                    modifier = Modifier.size(100.dp)
                )
                Column(modifier = Modifier.weight(1f)) {
                    Text(stringResource(title))
                    Text(stringResource(description))
                }
                Text("$$price")
            }
        }
    }
    FakeCardEntryPanel(onClick)
}


@Composable
fun FakeCardEntryPanel(onClick: () -> Unit) {
    val expanded = true
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
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
                Row() {
                    Text("Fake Card Entry Panel")
                    Icon(
                        Icons.Filled.KeyboardArrowDown,
                        contentDescription = null,
                        modifier = Modifier.clickable(onClick = { !expanded })
                    )
                }
                if (expanded) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Card Number") }
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Name on Card") }
                    )
                    Row {
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = { Text("Expiry Date") },
                            modifier = Modifier.weight(1f)
                        )
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = { Text("CCV") },
                            modifier = Modifier.weight(1f)
                        )
                        OutlinedButton(
                            onClick = onClick,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Pay")
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CheckoutScreenPreview() {
    FakeCardEntryPanel({})
}