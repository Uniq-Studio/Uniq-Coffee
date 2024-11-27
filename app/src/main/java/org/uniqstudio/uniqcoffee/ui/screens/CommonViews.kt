package org.uniqstudio.uniqcoffee.ui.screens

import android.R.attr.textSize
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun HeaderText(@StringRes text: Int, bold: Boolean, size: Int) {
    if (!bold){
    Text(
        text = stringResource(text),
        style = MaterialTheme.typography.headlineLarge,
        fontSize = size.sp,
    )
    } else {
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            fontSize = size.sp,
        )
    }
}

@Composable
fun DescriptionText(@StringRes text: Int) {
    Text(
        text = stringResource(text),
        modifier = Modifier.padding(10.dp)
    )
}

@Composable
fun TextBoxed(@StringRes text: Int, bold: Boolean, size: Int){
    if (!bold) {
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.headlineMedium,
            fontSize = size.sp
        )
    } else {
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            fontSize = size.sp
        )
    }
}

@Composable
fun CoffeeButton(
    @DrawableRes image: Int,
    @StringRes text: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FilledTonalButton(
        onClick = onClick,
        shape = MaterialTheme.shapes.extraSmall
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = stringResource(text),
                modifier = modifier.size(100.dp)
                    .padding(15.dp)
            )
            Text(
                text = stringResource(text),
                fontSize = 20.sp,
            )
        }

    }
}

@Composable
fun HiddenDetailsBox(
    @StringRes title: Int,
    @StringRes type: Int,
    justNumbers: Boolean,
    @StringRes description: Int
){
    var expanded: Boolean by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
                Row()
                {
                    Spacer(modifier = Modifier.size(10.dp))

                    TextBoxed(title, true, 20)

                    Spacer(modifier = Modifier.weight(1f))

                    if (!justNumbers){
                    TextBoxed(type, false, 20)
                    } else {
                        Text("$type",
                            fontSize = 20.sp,
                            modifier = Modifier.padding(top = 5.dp)
                        )
                    }

                    if (expanded) {
                        Icon(Icons.Filled.KeyboardArrowUp, contentDescription = null, modifier = Modifier.clickable( onClick = {expanded = !expanded}))
                    } else {
                        Icon(Icons.Filled.KeyboardArrowDown, contentDescription = null, modifier = Modifier.clickable( onClick = {expanded = !expanded}))
                    }
                }

                if (expanded) {
                    Row() {
                        Text(stringResource(description)
                            , modifier = Modifier.padding(10.dp))
                    }

                }
            }
        }
    }

@Composable
fun BottomBarButton(@StringRes text: Int, onClick: () -> Unit){
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        FilledTonalButton(
            onClick = onClick,
            shape = MaterialTheme.shapes.extraSmall,
            modifier = Modifier.fillMaxWidth()
                .height(75.dp)
        ) {
            TextBoxed(text, true, 25)
        }
    }
}


@Preview
@Composable
fun HeaderTextPreview(){
    HeaderText(R.string.welcome_back, false, 30)
}

@Preview
@Composable
fun DescriptionTextPreview(){
    DescriptionText(R.string.espresso_description)
}

@Preview
@Composable
fun CoffeeButtonPreview(){
    CoffeeButton(R.drawable.espresso, R.string.espresso, {})
}

@Preview
@Composable
fun HiddenDetailsBoxPreview(){
    HiddenDetailsBox(R.string.milk_type, R.string.milk_semi, false, R.string.milk_semi)
}

@Preview
@Composable
fun BottomBarButtonPreview(){
    BottomBarButton(R.string.add_to_cart, {})
}