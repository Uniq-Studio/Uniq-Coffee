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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.uniqstudio.uniqcoffee.R
import org.uniqstudio.uniqcoffee.ui.TopAppBar

@Composable
fun SelectedCoffeeCard(@DrawableRes image: Int, @StringRes title: Int, price: Double, onClick: () -> Unit) {
        Column(
            modifier = Modifier.padding(25.dp)
        ) {
            TopAppBar(R.string.payment)

            Spacer(modifier = Modifier.padding(10.dp))

            Card(
                modifier = Modifier.height(100.dp)
            ) {
                Row() {
                    Image(
                        painter = painterResource(image),
                        contentDescription = stringResource(title),
                        modifier = Modifier
                            .size(100.dp)
                            .padding(5.dp)
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Spacer(Modifier.padding(top = 5.dp))
                        TextBoxed(title, true, 30)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "$$price",
                            fontSize = 20.sp,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                    }
                }
            }
        }
    FakeCardEntryPanel(onClick)
}


@Composable
fun FakeCardEntryPanel(onClick: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
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
                    Spacer(modifier = Modifier.padding(5.dp))
                    TextBoxed(R.string.card_number, true, 20)
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        if (expanded) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowUp,
                        contentDescription = null,
                        modifier = Modifier.clickable(onClick = { expanded = !expanded })
                    )
                }
                if (expanded) {
                    InputField(R.string.card_number,5,true)
                    InputField(R.string.card_name,5,false)
                    InputFieldRow(R.string.card_expirery,R.string.card_cvv,6)
                    OutlinedButton(
                        onClick = onClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(3.dp)
                        ) {
                            TextBoxed(R.string.pay, true, 25)
                        }
                    }
                }
            }
        }
    }


@Preview
@Composable
fun CheckoutScreenPreview() {
//SelectedCoffeeCard(R.drawable.espresso, R.string.espresso, R.string.espresso_description, 2.99, {})
}