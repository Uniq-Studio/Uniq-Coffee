package org.uniqstudio.uniqcoffee.ui.screens.oob

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.uniqstudio.uniqcoffee.R
import org.uniqstudio.uniqcoffee.ui.OrderViewModel

enum class UniqCoffeeScreen(@StringRes val title: Int){
    Welcome(R.string.welcome),
    Name(R.string.user_name),
    Payment(R.string.preferred_payment),
    SetupDone(R.string.uniq_setup_done),
}

@Composable
fun OutOfBoxApp(
    navController: NavHostController = rememberNavController(),
    viewModel: OrderViewModel,
    launchApp: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    NavHost(
        navController = navController,
        startDestination = UniqCoffeeScreen.Welcome.name
    ) {
        composable(route = UniqCoffeeScreen.Welcome.name) {
            DialogScreen(
                R.string.welcome,
                45,
                R.string.app_name,
                { navController.navigate(UniqCoffeeScreen.Name.name) }
            )
        }
        composable(route = UniqCoffeeScreen.Name.name) {
            UserInputScreen(
                R.string.what_is_your_name,
                true,
                { navController.navigate(UniqCoffeeScreen.Payment.name) },
                viewModel
            )
        }
        composable(route = UniqCoffeeScreen.Payment.name){
            UserInputScreen(
                R.string.preferred_payment,
                false,
                { navController.navigate(UniqCoffeeScreen.SetupDone.name) },
                viewModel
            )
        }
        composable(route = UniqCoffeeScreen.SetupDone.name) {
            DialogScreen(
                R.string.uniq_setup_done,
                25,
                R.string.thank_you,
                {
                    viewModel.firstTimeSetUpComplete()
                    launchApp()
                }
            )
        }
    }
}
