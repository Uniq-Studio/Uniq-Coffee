package org.uniqstudio.uniqcoffee.ui.screens


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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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
fun HeaderText(text: String, bold: Boolean, size: Int) {
    if (!bold){
        Text(
            text = text,
            style = MaterialTheme.typography.headlineLarge,
            fontSize = size.sp,
        )
    } else {
        Text(
            text = text,
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

                    if (description != 0) {
                        if (expanded) {
                            Icon(
                                Icons.Filled.KeyboardArrowUp,
                                contentDescription = null,
                                modifier = Modifier.clickable(onClick = { expanded = !expanded })
                            )
                        } else {
                            Icon(
                                Icons.Filled.KeyboardArrowDown,
                                contentDescription = null,
                                modifier = Modifier.clickable(onClick = { expanded = !expanded })
                            )
                        }
                    }
                }

                if (expanded) {
                    Row {
                        Text(stringResource(description)
                            , modifier = Modifier.padding(10.dp))
                    }

                }
            }
        }
    }


@Composable
fun InputField(@StringRes text: Int, size: Int, justNumbers: Boolean){
    var keyboardType: KeyboardType
    if (justNumbers){
        keyboardType = KeyboardType.Number
    } else {
        keyboardType = KeyboardType.Text
    }
    var inputtedText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = inputtedText,
        onValueChange = {inputtedText = it},
        label = { Text(stringResource(text)) },
        singleLine = true,
        keyboardOptions = (KeyboardOptions.Default.copy(
            keyboardType = keyboardType,
            imeAction = ImeAction.Next)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(size.dp)
    )
}

@Composable
fun InputFieldRow(@StringRes expiryDate: Int,@StringRes cvvText: Int, size: Int){
    var inputtedText1 by remember { mutableStateOf("") }
    var inputtedText2 by remember { mutableStateOf("") }
    Row {
        OutlinedTextField(
            value = inputtedText1,
            onValueChange = {inputtedText1 = it},
            label = { Text(stringResource(expiryDate)) },
            singleLine = true,
            keyboardOptions = (KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next)),
            modifier = Modifier
                .weight(1f)
                .padding(size.dp),
        )
        OutlinedTextField(
            value = inputtedText2,
            onValueChange = {inputtedText2 = it},
            label = { Text(stringResource(cvvText)) },
            singleLine = true,
            keyboardOptions = (KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done)),
            modifier = Modifier
                .weight(1f)
                .padding(size.dp)
        )
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
            TextBoxed(text, true, 20)
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
fun TextBoxedPreview(){
    TextBoxed(R.string.espresso, true, 20)
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
fun InputFieldPreview(){
    InputField(R.string.card_number, 5, true)
}

@Preview
@Composable
fun InputFieldRowPreview(){
    InputFieldRow(R.string.card_expiry, R.string.card_cvv, 6)
}

@Preview
@Composable
fun BottomBarButtonPreview(){
    BottomBarButton(R.string.add_to_cart, {})
}