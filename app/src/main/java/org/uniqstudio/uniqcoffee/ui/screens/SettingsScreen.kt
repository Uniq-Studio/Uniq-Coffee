package org.uniqstudio.uniqcoffee.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import org.uniqstudio.uniqcoffee.R
import org.uniqstudio.uniqcoffee.ui.OrderViewModel
import org.uniqstudio.uniqcoffee.ui.TopAppBar

@Composable
fun SettingsScreen (onClickBack: () -> Unit, onClickAbout: () -> Unit, viewModel: OrderViewModel){

    //We get the current username from the view model
    val uiState by viewModel.uiState.collectAsState()

    var inputUsername by remember { mutableStateOf(uiState.userName) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(R.string.settings, 2.25f, true, onClickBack)

        Text(text = uiState.userName)

        OutlinedTextField(
            value = inputUsername,
            onValueChange = { inputUsername = it},
            label = { Text(stringResource(R.string.user_name)) },
            singleLine = true,
            keyboardOptions = (KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )

        OutlinedButton(onClick = {viewModel.updateUserName(inputUsername)}) { }
    }
    BottomBarButton(R.string.about, onClickAbout)
}