package org.uniqstudio.uniqcoffee.ui

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.uniqstudio.uniqcoffee.R
import org.uniqstudio.uniqcoffee.ui.screens.AboutCreatorScreenApp
import org.uniqstudio.uniqcoffee.ui.screens.AboutScreenApp
import org.uniqstudio.uniqcoffee.ui.screens.CoffeeDetailsScreen
import org.uniqstudio.uniqcoffee.ui.screens.CoffeeSelectionApp
import org.uniqstudio.uniqcoffee.ui.screens.HomeScreenApp
import org.uniqstudio.uniqcoffee.ui.screens.OrderCompletedView
import org.uniqstudio.uniqcoffee.ui.screens.SelectedCoffeeCard
import org.uniqstudio.uniqcoffee.ui.screens.SettingsScreen
import org.uniqstudio.uniqcoffee.ui.screens.oob.OutOfBoxApp


enum class UniqCoffeeScreen(@StringRes val title: Int){
    OOB(R.string.welcome),
    Start(R.string.app_name),
    Settings(R.string.settings),
    About(R.string.about),
    AboutCreator(R.string.about_creator),
    Selection(R.string.select_coffee),
    Details(R.string.coffee_details),
    CheckOut(R.string.payment),
    Complete(R.string.thank_you)
}

@Composable
fun UniqCoffeeApp(
    navController: NavHostController = rememberNavController(),
    viewModel: OrderViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var FTSU = uiState.FTSUCompleted

    NavHost(
        navController = navController,
        if (!FTSU) UniqCoffeeScreen.OOB.name else UniqCoffeeScreen.Start.name,
    ) {
        composable(route = UniqCoffeeScreen.OOB.name) {
            OutOfBoxApp(
                viewModel = viewModel,
                launchApp = {
                    navController.navigate(UniqCoffeeScreen.Start.name)
            })
        }
        composable(route = UniqCoffeeScreen.Start.name) {
            HomeScreenApp(
                R.string.welcome_back,
                uiState.userName,

                uiState.currentStamp,
                uiState.totalStamp,
                uiState.freeCoffees,

                R.drawable.settings,
                R.string.settings,
                { navController.navigate(UniqCoffeeScreen.Settings.name) },

                R.drawable.coffee_bean,
                R.string.order,
                { navController.navigate(UniqCoffeeScreen.Selection.name) },
            )
        }

        composable(route = UniqCoffeeScreen.Settings.name){
            SettingsScreen(
                onClickBack = { navController.navigateUp() },
                onClickAbout = { navController.navigate(UniqCoffeeScreen.About.name) },
                viewModel
            )
        }
        composable(route = UniqCoffeeScreen.About.name) {
            AboutScreenApp(
                onClickBack = { navController.navigateUp() },
                onClickAboutCreator = { navController.navigate(UniqCoffeeScreen.AboutCreator.name) }
            )
        }
        composable(route = UniqCoffeeScreen.AboutCreator.name) {
            AboutCreatorScreenApp(
                onClickBack = { navController.navigateUp() }
            )
        }

        composable(route = UniqCoffeeScreen.Selection.name) {
            CoffeeSelectionApp(
                onClickCoffee = {
                    navController.navigate(UniqCoffeeScreen.Details.name)
                },
                onClickBack = { navController.navigateUp() },
                viewModel
            )
        }

        composable(route = UniqCoffeeScreen.Details.name) {
            CoffeeDetailsScreen(
                uiState.selectedCoffee,
                uiState.selectedCoffeePrice,

                uiState.selectedCoffeeImage,

                uiState.selectedCoffeeDescription,

                uiState.selectedCoffeeMilkType,
                uiState.selectedCoffeeMilkTypeDescription,

                uiState.selectedCoffeeKcal,

                { navController.navigate(UniqCoffeeScreen.CheckOut.name) }
            )
        }

        composable(route = UniqCoffeeScreen.CheckOut.name) {
            SelectedCoffeeCard(
                uiState.selectedCoffeeImage,
                uiState.selectedCoffee,
                uiState.selectedCoffeePrice,
                {
                    viewModel.updateCurrentStamp(uiState.currentStamp + 1)
                    navController.navigate("complete") {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = false
                        }
                    }
                },
                {
                    viewModel.updateCurrentStamp(uiState.currentStamp + 1)
                    navController.navigate("complete") {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = false
                        }
                    }},

                {
                    viewModel.useFreeCoffee()
                    navController.navigate("complete") {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = false
                        }
                    }
                },

                { navController.navigateUp()},
                uiState.freeCoffees,
                    viewModel
                )
            }

        composable(route = UniqCoffeeScreen.Complete.name) {
            OrderCompletedView(
                R.string.thank_you,
                R.string.being_made,
                {
                    navController.navigate("start") {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = false
                        }
                    }
                })
        }

    }
}
