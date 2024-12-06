package org.uniqstudio.uniqcoffee.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import org.uniqstudio.uniqcoffee.R
import org.uniqstudio.uniqcoffee.ui.OrderViewModel
import org.uniqstudio.uniqcoffee.ui.TopAppBar

@Composable
fun SettingsScreen(onClickBack: () -> Unit, onClickAbout: () -> Unit, viewModel: OrderViewModel) {

    //We get the current username from the view model
    val uiState by viewModel.uiState.collectAsState()

    var updateUsername by remember { mutableStateOf(uiState.userName) }

    var updateCardNumber by remember { mutableStateOf(uiState.cardNumber) }
    var updateCardName by remember { mutableStateOf(uiState.cardName) }
    var updateCardExpiry by remember { mutableStateOf(uiState.cardExpiry) }
    var updateCardCvv by remember { mutableStateOf(uiState.cardCvv) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(R.string.settings, onClickBack)

        Column(Modifier.padding(20.dp)) {
            HeaderText(R.string.uniq_id, true, 50)

            Spacer(modifier = Modifier.size(10.dp))

            HeaderText(R.string.personal_info, false, 20)

            OutlinedTextField(
                value = updateUsername,
                onValueChange = { updateUsername = it },
                label = { Text(stringResource(R.string.current_username)) },
                singleLine = true,
                keyboardOptions = (KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                )),
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(30.dp))

            HeaderText(R.string.card_info, false, 20)

            OutlinedTextField(
                value = updateCardNumber,
                onValueChange = { updateCardNumber = it },
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
                value = updateCardName,
                onValueChange = { updateCardName = it },
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
                    value = updateCardExpiry,
                    onValueChange = { updateCardExpiry = it },
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
                    value = updateCardCvv,
                    onValueChange = { updateCardCvv = it },
                    label = { Text(stringResource(R.string.card_cvv) + ":") },
                    singleLine = true,
                    keyboardOptions = (KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    )),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            OutlinedButton(onClick = {
                viewModel.updateUserName(updateUsername)
                viewModel.updateCardDetails(
                    cardNumber = updateCardNumber,
                    cardName = updateCardName,
                    cardExpiry = updateCardExpiry,
                    cardCvv = updateCardCvv
                )
            }) {
                HeaderText(R.string.update_info, false, 20)
            }
        }
    }
    BottomBarButton(R.string.about, onClickAbout)
}