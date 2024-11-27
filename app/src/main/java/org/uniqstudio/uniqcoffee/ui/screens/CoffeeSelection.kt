package org.uniqstudio.uniqcoffee.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.uniqstudio.uniqcoffee.R
import org.uniqstudio.uniqcoffee.data.CoffeeDataSource
import org.uniqstudio.uniqcoffee.model.Coffee
import org.uniqstudio.uniqcoffee.ui.TopAppBar

@Composable
fun CoffeeSelectionApp(onClick: () -> Unit) {
    CoffeeSelectionScreen(CoffeeDataSource().loadCoffee(),
        onClick = onClick)
}

@Composable
fun CoffeeSelectionScreen( coffeeList: List<Coffee>,
                           onClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(R.string.select_coffee)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
        ) {
            items(coffeeList) { coffee ->
                CoffeeCard(
                    modifier = Modifier
                        .size(width = 200.dp, height = 300.dp),
                    coffee = coffee,
                    onClick = onClick,
                )
            }
        }
    }
}

@Composable
fun CoffeeCard(
    modifier: Modifier = Modifier,
    coffee: Coffee,
    onClick: () -> Unit = {},
) {
    Card(
        modifier = modifier.padding(8.dp),
    ) {
        Card(
            onClick = onClick,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(coffee.imageResourceId),
                    contentDescription = stringResource(coffee.titleResourceId),
                    modifier = Modifier.padding(10.dp)
                )
                TextBoxed(coffee.titleResourceId, true, 25)
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

