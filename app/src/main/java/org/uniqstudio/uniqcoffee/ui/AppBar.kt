package org.uniqstudio.uniqcoffee.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.uniqstudio.uniqcoffee.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(@StringRes title: Int, onClickBack: () -> Unit = {}) {
    Box (modifier = Modifier.padding(top = 50.dp)) {
        BackBarButton(onClickBack)
        TextBar(title)
    }
}

@Composable
fun BackBarButton(onClickBack: () -> Unit){
    Row (
        modifier = Modifier.fillMaxWidth()
            .height(75.dp)
            .padding(start = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            Modifier.size(30.dp)
                .clickable(onClick = onClickBack),
        )
    }
}


@Composable
fun TextBar(@StringRes title: Int){
        Row(
            Modifier.fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.coffee_bean),
                contentDescription = null,
                Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                text = stringResource(id = title),
                style = MaterialTheme.typography.titleLarge,

                )
        }
    }
