package org.uniqstudio.uniqcoffee.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(@StringRes title: Int){
    CenterAlignedTopAppBar(
        title = {
            Row(modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically) {
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
        })
}

@Preview
@Composable
fun TopBarPreview(){
        TopAppBar(title = R.string.app_name)
}
