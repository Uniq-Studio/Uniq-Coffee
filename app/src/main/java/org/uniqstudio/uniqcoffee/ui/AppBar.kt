package org.uniqstudio.uniqcoffee.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.uniqstudio.uniqcoffee.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(@StringRes title: Int, size: Float, goBack: Boolean = false, onClickBack: () -> Unit = {}) {
    var viewable = 0.0f
    if (goBack){ viewable = 1.0f }
    CenterAlignedTopAppBar(
        title = {
            Row(
                modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier
                    .clickable(onClick = onClickBack)
                    .weight(1f))
                {
                    Image(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        Modifier.size(30.dp)
                            .alpha(viewable)
                        )
                    }
                Row (modifier = Modifier.weight(size),
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
            }
        })

}

@Preview
@Composable
fun TopBarPreview(){
        TopAppBar(title = R.string.app_name, 3f, true)
}
