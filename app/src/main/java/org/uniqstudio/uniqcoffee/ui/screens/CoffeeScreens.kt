package org.uniqstudio.uniqcoffee.ui.screens

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.uniqstudio.uniqcoffee.R
import org.uniqstudio.uniqcoffee.data.OrderUiState


enum class UniqCoffeeScreen(@StringRes val title: Int){
    Start(R.string.app_name),
    Selection(R.string.select_coffee),
    Details(R.string.coffee_details),
    CheckOut(R.string.payment),
    Complete(R.string.thank_you)
}

@Composable
fun UniqCoffeeApp(
    navController: NavHostController = rememberNavController(),
    orderUiState: OrderUiState = OrderUiState()
) {
    NavHost(
        navController = navController,
        startDestination = UniqCoffeeScreen.Start.name
    ) {
        composable(route = UniqCoffeeScreen.Start.name) {
            HomeScreenApp(
                R.string.welcome_back,
                orderUiState.userName,
                orderUiState.currentStamp,
                10,
                R.drawable.settings,
                R.string.settings,
                {},
                R.drawable.coffee_bean,
                R.string.order,
                {
                    navController.navigate(UniqCoffeeScreen.Selection.name)
                }
            )
        }

        composable(route = UniqCoffeeScreen.Selection.name) {
            CoffeeSelectionApp(
                onClickCoffee = {
                    navController.navigate(UniqCoffeeScreen.Details.name)
                },
                onClickBack = {
                    navController.navigateUp()
                })
        }

        composable(route = UniqCoffeeScreen.Details.name) {
            CoffeeDetailsScreen(
                orderUiState.selectedCoffee,
                orderUiState.selectedCoffeePrice,
                orderUiState.selectedCoffeeImage,
                orderUiState.selectedCoffeeDescription,
                orderUiState.selectedCoffeeMilkType,
                orderUiState.selectedCoffeeKcal,
                {
                    navController.navigate(UniqCoffeeScreen.CheckOut.name)
                }
            )
        }

        composable(route = UniqCoffeeScreen.CheckOut.name) {
                SelectedCoffeeCard(
                    orderUiState.selectedCoffeeImage,
                    orderUiState.selectedCoffee,
                    orderUiState.selectedCoffeePrice,
                    {
                        navController.navigate("complete") {
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = false
                            }
                        }
                    },
                    {navController.navigateUp()}
                )
            }

        composable(route = UniqCoffeeScreen.Complete.name) {
            OrderCompletedView(
                R.string.thank_you,
                R.string.being_made,
                {navController.navigate("start") {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = false
                    }
                    }
                })
        }

    }
}
