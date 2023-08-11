package co.nimblehq.kmm.template.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import co.nimblehq.kmm.template.android.screen.signin.SignInScreen
import co.nimblehq.kmm.template.android.screen.splash.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = SurveyDestination.Splash.route,
        modifier = modifier
    ) {
        composable(SurveyDestination.Splash) {
            SplashScreen()
        }

        composable(SurveyDestination.SignIn) {
            SignInScreen()
        }
    }
}

private fun NavGraphBuilder.composable(
    destination: SurveyDestination,
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit,
) {
    composable(
        route = destination.route,
        arguments = destination.arguments,
        deepLinks = deepLinks,
        content = content
    )
}

