package org.uniqstudio.uniqcoffee.ui.screens

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.uniqstudio.uniqcoffee.R

enum class UniqCoffeeScreen(@StringRes val title: Int){
    Start(R.string.app_name),
    Selection(R.string.select_coffee),
    Details(R.string.coffee_details),
    CheckOut(R.string.payment),
    Complete(R.string.thank_you)
}

@Composable
fun UniqCoffeeApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = UniqCoffeeScreen.Start.name
    ) {
        composable(route = UniqCoffeeScreen.Start.name) {
            HomeScreenApp(
                R.string.welcome_back,
                R.string.user_name_temp,
                3,
                10,
                R.drawable.coffee_bean,
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
                onClick = {
                    navController.navigate(UniqCoffeeScreen.Details.name)
                })
        }

        composable(route = UniqCoffeeScreen.Details.name) {
            CoffeeDetailsScreen(
                R.string.espresso,
                2.99,
                R.drawable.espresso,
                R.string.espresso_description,
                R.string.milk_semi,
                100,
                {
                    navController.navigate(UniqCoffeeScreen.CheckOut.name)
                }
            )
        }

        composable(route = UniqCoffeeScreen.CheckOut.name) {
            SelectedCoffeeCard(
                R.drawable.espresso,
                R.string.espresso,
                R.string.espresso_description,
                2.99,
                {
                    navController.navigate(UniqCoffeeScreen.Complete.name)
                }
            )
        }

        composable(route = UniqCoffeeScreen.Complete.name) {
            OrderCompletedView(
                R.string.thank_you,
                R.string.being_made,
                {
                    navController.navigate(UniqCoffeeScreen.Start.name)
                })
        }

    }
}