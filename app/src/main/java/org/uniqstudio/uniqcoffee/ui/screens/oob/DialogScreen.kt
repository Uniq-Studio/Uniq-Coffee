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
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.uniqstudio.uniqcoffee.ui.screens.HeaderText
import org.uniqstudio.uniqcoffee.R

@Composable
fun DialogScreen(
    @StringRes title: Int,
    textSize: Int,
    @StringRes subtitle: Int,
    onClickNext: () -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        HeaderText(title, false, textSize)
        HeaderText(subtitle, true, 60)

        Spacer(modifier = Modifier.size(150.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = onClickNext,
                modifier = Modifier.size(150.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.broken_arrow_right),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(15.dp)
                        .size(150.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    DialogScreen(R.string.welcome, 45, R.string.app_name, {})
}

@Preview
@Composable
fun SetUpScreenPreview() {
    DialogScreen(R.string.uniq_setup_done, 25, R.string.thank_you, {})
}