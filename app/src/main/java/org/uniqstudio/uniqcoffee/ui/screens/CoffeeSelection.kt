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
import androidx.lifecycle.viewmodel.compose.viewModel
import org.uniqstudio.uniqcoffee.R
import org.uniqstudio.uniqcoffee.data.CoffeeDataSource
import org.uniqstudio.uniqcoffee.model.Coffee
import org.uniqstudio.uniqcoffee.ui.OrderViewModel
import org.uniqstudio.uniqcoffee.ui.TopAppBar

//This screen collects all the different coffees and displays them in a grid.

@Composable
fun CoffeeSelectionApp(
    onClickCoffee: () -> Unit,
    onClickBack: () -> Unit,
    viewModel: OrderViewModel
) {
    CoffeeSelectionScreen(
        coffeeList = CoffeeDataSource().loadCoffee(),
        onClickCoffee = onClickCoffee,
        onClickBack = onClickBack,
        viewModel = viewModel
    )
}

@Composable
fun CoffeeSelectionScreen(
    coffeeList: List<Coffee>,
    onClickCoffee: () -> Unit,
    onClickBack: () -> Unit,
    viewModel: OrderViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(R.string.select_coffee, onClickBack = onClickBack)
        //Create Scrollable Grid of coffees
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
        ) {
            //Load the coffees from our list
            items(coffeeList) { coffee ->
                CoffeeCard(
                    modifier = Modifier
                        .size(width = 200.dp, height = 300.dp),
                    coffee = coffee,
                    onClick = onClickCoffee,
                    viewModel = viewModel
                )
            }
        }
    }
}


//This Displays the image of the coffee and the name of the coffee.
//OnClick will add the coffee that it is to the ViewModel
@Composable
fun CoffeeCard(
    modifier: Modifier = Modifier,
    coffee: Coffee,
    onClick: () -> Unit = {},
    viewModel: OrderViewModel
) {
    Card(
        modifier = modifier.padding(8.dp),
    ) {
        Card(
            onClick =
                {
                    viewModel.updateCoffeeSelectionScreen(
                        selectedCoffee = coffee.titleResourceId,
                        price = coffee.price,
                        image = coffee.imageResourceId,
                        description = coffee.descriptionResourceId,
                        milkType = coffee.milkTypeResourceId,
                        milkDescription = coffee.milkDescriptionResourceId,
                        kcal = coffee.kcal
                    )
                    onClick()
                }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(coffee.imageResourceId),
                    contentDescription = stringResource(coffee.titleResourceId),
                    modifier = Modifier.padding(10.dp)
                )
                TextBoxed(
                    text = coffee.titleResourceId,
                    bold = true,
                    size = 25
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
            milkDescriptionResourceId = 0,
            price = 2.99,
            kcal = 100
        ),
        onClick = {},
        viewModel = viewModel()
    )
}

