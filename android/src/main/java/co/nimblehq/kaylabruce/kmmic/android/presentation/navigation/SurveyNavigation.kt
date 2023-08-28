package co.nimblehq.kaylabruce.kmmic.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.*
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.home.HomeScreen
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.signin.SignInScreen
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.splash.SplashScreen
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.surveydetail.SurveyDetailScreen

@Composable
fun SurveyNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = SurveyDestination.Splash.route,
        modifier = modifier
    ) {
        composable(SurveyDestination.Splash) {
            SplashScreen(
                onNavigate = {
                    navController.navigate(
                        route = SurveyDestination.SignIn.route,
                    )
                }
            )
        }

        composable(SurveyDestination.SignIn) {
            SignInScreen()
        }

        composable(SurveyDestination.SurveyList) {
            HomeScreen()
        }

        composable(SurveyDestination.SurveyDetail) {
            SurveyDetailScreen()
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

