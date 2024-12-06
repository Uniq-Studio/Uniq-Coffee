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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.uniqstudio.uniqcoffee.R
import org.uniqstudio.uniqcoffee.ui.OrderViewModel
import org.uniqstudio.uniqcoffee.ui.TopAppBar

@Composable
fun SelectedCoffeeCard(
    @DrawableRes image: Int,
    @StringRes title: Int,
    price: Double,
    onClick: () -> Unit,
    onClickGPay: () -> Unit,
    onClickFree: () -> Unit,
    onClickBack: () -> Unit,
    freeCoffees: Int,
    viewModel: OrderViewModel
) {

    Column {
        TopAppBar(R.string.payment, onClickBack)

        Column(modifier = Modifier.padding(25.dp)) {
            Spacer(modifier = Modifier.padding(10.dp))

            Card(
                modifier = Modifier.height(100.dp)
            ) {
                Row {
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
    }
    PaymentPanel(onClick, onClickGPay, onClickFree, freeCoffees, viewModel)
}


@Composable
fun PaymentPanel(
    onClickCard: () -> Unit,
    onClickGPay: () -> Unit,
    onClickFree: () -> Unit,
    freeCoffees: Int,
    viewModel: OrderViewModel
) {
    Box(
        contentAlignment = Alignment.BottomCenter
    ) {
        Column {
            FakeCardEntryPanel(onClickCard, viewModel)
            OtherPaymentPanel(R.string.google_pay, onClickGPay)
            Spacer(Modifier.size(10.dp))
            if (freeCoffees > 0) OtherPaymentPanel(R.string.free_coffee_pay, onClickFree)
            Spacer(Modifier.size(10.dp))
        }
    }
}

@Composable
fun FakeCardEntryPanel(onClick: () -> Unit, viewModel: OrderViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    var expanded by remember { mutableStateOf(true) }

    var cardNumber by remember { mutableStateOf(uiState.cardNumber) }
    var cardName by remember { mutableStateOf(uiState.cardName) }
    var cardExpiry by remember { mutableStateOf(uiState.cardExpiry) }
    var cardCvv by remember { mutableStateOf(uiState.cardCvv) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Card {
            Column(
                modifier = Modifier
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioNoBouncy,
                            stiffness = Spring.StiffnessMedium
                        )
                    )
            ) {
                Row {
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
                    OutlinedTextField(
                        value = cardNumber,
                        onValueChange = { cardNumber = it },
                        label = { Text(stringResource(R.string.card_number)) },
                        singleLine = true,
                        keyboardOptions = (KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        )),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                    )
                    OutlinedTextField(
                        value = cardName,
                        onValueChange = { cardName = it },
                        label = { Text(stringResource(R.string.card_name)) },
                        singleLine = true,
                        keyboardOptions = (KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        )),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                    )

                    Row {
                        OutlinedTextField(
                            value = cardExpiry,
                            onValueChange = { cardExpiry = it },
                            label = { Text(stringResource(R.string.card_expiry)) },
                            singleLine = true,
                            keyboardOptions = (KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)
                                .weight(2f)
                        )
                        OutlinedTextField(
                            value = cardCvv,
                            onValueChange = { cardCvv = it },
                            label = { Text(stringResource(R.string.card_cvv)) },
                            singleLine = true,
                            keyboardOptions = (KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            )),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)
                                .weight(2f)
                        )
                        OutlinedButton(
                            onClick = {
                                viewModel.updateCardDetails(
                                    cardNumber,
                                    cardName,
                                    cardExpiry,
                                    cardCvv
                                )
                                onClick()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 5.dp, top = 15.dp, bottom = 5.dp, end = 5.dp)
                                .weight(1f)
                        ) {
                            Icon(
                                Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = null,
                                modifier = Modifier.size(ButtonDefaults.IconSize)
                            )
                        }
                    }


                }
            }
        }
    }
}

@Composable
fun OtherPaymentPanel(@StringRes title: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(start = 20.dp, end = 20.dp)
    ) {
        FilledTonalButton(
            onClick = onClick,
            shape = MaterialTheme.shapes.extraSmall,
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
        ) {
            TextBoxed(title, true, 20)
        }
    }
}


@Preview
@Composable
fun CheckoutScreenPreview() {
//SelectedCoffeeCard(R.drawable.espresso, R.string.espresso, R.string.espresso_description, 2.99, {})
    PaymentPanel({}, {}, {}, 1, viewModel())
}