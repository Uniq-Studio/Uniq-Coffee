package org.uniqstudio.uniqcoffee.ui.screens.oob

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.uniqstudio.uniqcoffee.ui.screens.HeaderText
import org.uniqstudio.uniqcoffee.R

@Composable
fun UserInputScreen(@StringRes title :Int, stageOne: Boolean, onClickNext: () -> Unit){

    var stageOne by remember { mutableStateOf(stageOne) }
    var username by remember { mutableStateOf("") }

    var cardNumber by remember { mutableStateOf("") }
    var cardName by remember { mutableStateOf("") }
    var cardExpiry by remember { mutableStateOf("") }
    var cardCvv by remember { mutableStateOf("") }
    Column(
        Modifier.fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        HeaderText(R.string.setup_uniq_id, false, 30)
        HeaderText(title, true, 20)

        Spacer(modifier = Modifier.size(100.dp))
        if (stageOne) {
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(stringResource(R.string.user_name)) },
                singleLine = true,
                keyboardOptions = (KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )
        } else {
            OutlinedTextField(
                value = cardNumber,
                onValueChange = { cardNumber = it },
                label = { Text(stringResource(R.string.card_number) + ":") },
                singleLine = true,
                keyboardOptions = (KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                )),
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(10.dp))

            OutlinedTextField(
                value = cardName,
                onValueChange = { cardName = it },
                label = { Text(stringResource(R.string.card_name) + ":") },
                singleLine = true,
                keyboardOptions = (KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                )),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(10.dp))

            Row {
                OutlinedTextField(
                    value = cardExpiry,
                    onValueChange = { cardExpiry = it },
                    label = { Text(stringResource(R.string.card_expiry) + ":") },
                    singleLine = true,
                    keyboardOptions = (KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    )),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                Spacer(modifier = Modifier.size(10.dp))
                OutlinedTextField(
                    value = cardCvv,
                    onValueChange = { cardCvv = it },
                    label = { Text(stringResource(R.string.card_cvv) + ":") },
                    singleLine = true,
                    keyboardOptions = (KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    )),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            }
        }
        Spacer(modifier = Modifier.size(150.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = {
                    if (stageOne) {}
                    else {}
                    onClickNext()
                          },
                modifier = Modifier.size(100.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.coffee_bean),
                    contentDescription = null,
                    modifier = Modifier.padding(15.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun NameScreenPreview(){
    UserInputScreen(R.string.what_is_your_name, true, {})
}
@Preview
@Composable
fun CardScreenPreview(){
    UserInputScreen(R.string.preferred_payment, false, {})
}