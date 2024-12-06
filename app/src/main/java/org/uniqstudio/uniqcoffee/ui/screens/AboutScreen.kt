package org.uniqstudio.uniqcoffee.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.uniqstudio.uniqcoffee.ui.TopAppBar
import org.uniqstudio.uniqcoffee.R

//About screen for the app explaining what the app does and what it can do
//Displays a list of resources used and a disclaimer

@Composable
fun AboutScreenApp(onClickBack: () -> Unit, onClickAboutCreator: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = R.string.about,
            onClickBack = onClickBack
        )
        Column(
            Modifier.padding(bottom = 20.dp)
        ) {
            Spacer(Modifier.size(20.dp))
            Column(
                Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                //About the app
                HeaderText(
                    text = (R.string.about_app_title),
                    bold = true,
                    size = 45
                )
                DescriptionText(R.string.about_app_description)

                Spacer(Modifier.size(20.dp))

                //Resources Used
                HeaderText(
                    text = (R.string.resources_used),
                    bold = true,
                    size = 45)
                DescriptionText(R.string.resources_used_description)

                Spacer(Modifier.size(20.dp))

                //Disclaimer
                HeaderText(
                    text = (R.string.disclaimer_title),
                    bold = true,
                    size = 45
                )
                DescriptionText(R.string.disclaimer_description)

                //Making sure the button does not cover up any text
                Spacer(Modifier.size(50.dp))
            }
        }
    }
    //Takes you to the About Creator Screen
    BottomBarButton(
        text = R.string.about_creator,
        onClick = onClickAboutCreator
    )
}