package org.uniqstudio.uniqcoffee.ui.screens.oob

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.uniqstudio.uniqcoffee.R
import org.uniqstudio.uniqcoffee.ui.OrderViewModel

enum class UniqCoffeeScreen(@StringRes val title: Int) {
    Welcome(R.string.welcome),
    Name(R.string.user_name),
    Payment(R.string.preferred_payment),
    SetupDone(R.string.uniq_setup_done),
}

//Out of box experience is designed to gain the user's info
//Once complete, it takes them to the main app

@Composable
fun OutOfBoxApp(
    navController: NavHostController = rememberNavController(),
    viewModel: OrderViewModel,
    launchApp: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = UniqCoffeeScreen.Welcome.name
    ) {
        composable(route = UniqCoffeeScreen.Welcome.name) {
            DialogScreen(
                title = R.string.welcome,
                textSize = 45,
                subtitle = R.string.app_name,
                onClickNext = { navController.navigate(UniqCoffeeScreen.Name.name) }
            )
        }
        composable(route = UniqCoffeeScreen.Name.name) {
            UserInputScreen(
                title = R.string.what_is_your_name,
                stageOne = true,
                onClickNext = { navController.navigate(UniqCoffeeScreen.Payment.name) },
                viewModel = viewModel
            )
        }
        composable(route = UniqCoffeeScreen.Payment.name) {
            UserInputScreen(
                title = R.string.preferred_payment,
                stageOne = false,
                onClickNext = { navController.navigate(UniqCoffeeScreen.SetupDone.name) },
                viewModel = viewModel
            )
        }
        composable(route = UniqCoffeeScreen.SetupDone.name) {
            DialogScreen(
                title = R.string.uniq_setup_done,
                textSize = 25,
                subtitle = R.string.thank_you,
                onClickNext = {
                    viewModel.firstTimeSetUpComplete()
                    launchApp()
                }
            )
        }
    }
}
