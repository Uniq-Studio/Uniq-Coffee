package org.uniqstudio.uniqcoffee.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.uniqstudio.uniqcoffee.R

@Composable
fun CheckImage() {
    Image(
        painter = painterResource(R.drawable.ic_task_completed),
        contentDescription = null
    )
}

@Composable
fun CompletedText(@StringRes thankYou: Int, @StringRes inProgress: Int) {
    Text(
        stringResource(thankYou),
        modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )
    Text(
        stringResource(inProgress),
        fontSize = 16.sp
    )
}

@Composable
fun OrderCompletedView(@StringRes completed: Int, @StringRes praise: Int, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CheckImage()
        CompletedText(completed, praise)
    }

    BottomBarButton(R.string.back, onClick)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OrderCompletedView(R.string.thank_you, R.string.being_made, {})
}