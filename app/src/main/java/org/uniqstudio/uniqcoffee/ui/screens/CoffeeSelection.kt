package org.uniqstudio.uniqcoffee.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.uniqstudio.uniqcoffee.R
import org.uniqstudio.uniqcoffee.data.CoffeeDataSource
import org.uniqstudio.uniqcoffee.model.Coffee

@Composable
fun CoffeeSelectionApp() {
    CoffeeSelectionScreen(CoffeeDataSource().loadCoffee())
}

@Composable
fun CoffeeSelectionScreen( coffeeList: List<Coffee>
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(coffeeList) {
            coffee -> CoffeeCard(coffee, modifier = Modifier.size(100.dp))
        }
    }
}

@Composable
fun CoffeeCard(
    coffee: Coffee,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Card(

    ) {
        FilledTonalButton(
            onClick = onClick,
            shape = MaterialTheme.shapes.extraSmall
        ) {
            Column() {
                Image(
                    painter = painterResource(coffee.imageResourceId),
                    contentDescription = stringResource(coffee.titleResourceId),
                    modifier = modifier.size(100.dp)
                )
                Text(
                    text = stringResource(coffee.titleResourceId)
                )
            }

        }
    }
}


@Preview
@Composable
fun CoffeeSelectionScreenPreview() {
    CoffeeCard(
        coffee = Coffee(
            imageResourceId = R.drawable.espresso,
            titleResourceId = R.string.espresso,
            descriptionResourceId = R.string.espresso_description,
            milkTypeResourceId = R.string.milk_none,
            price = 2.99,
            kcal = 100
        ),
        onClick = {}
    )
}

