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

@Composable
fun AboutScreenApp(onClickBack: () -> Unit, onClickAboutCreator: () -> Unit){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(R.string.about, 2f, true, onClickBack)
        Column(
            Modifier.padding(bottom = 20.dp)
        ) {
            Spacer(Modifier.size(20.dp))
            Column(
                Modifier.padding(start = 20.dp, end = 20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                HeaderText((R.string.about_app_title), true, 45)
                DescriptionText(R.string.about_app_description)
                Spacer(Modifier.size(20.dp))
                HeaderText((R.string.resources_used), true, 45)
                DescriptionText(R.string.resources_used_description)
                Spacer(Modifier.size(20.dp))
                HeaderText((R.string.disclaimer_title), true, 45)
                DescriptionText(R.string.disclaimer_description)
                Spacer(Modifier.size(50.dp))
            }
        }
    }
    BottomBarButton(R.string.about_creator, onClickAboutCreator)
}