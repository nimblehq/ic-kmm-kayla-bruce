package co.nimblehq.kaylabruce.kmmic.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.*
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.home.HomeScreen
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.signin.SignInScreen
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.splash.SplashScreen
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.surveydetail.SurveyDetailScreen
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.surveyquestion.SurveyQuestionScreen

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
                    // TODO: Navigate Between Splash, Sign in and Home screen
                    navController.navigate(destination = SurveyDestination.Home)
                }
            )
        }

        composable(SurveyDestination.SignIn) {
            SignInScreen()
        }

        composable(SurveyDestination.Home) {
            HomeScreen(
                onNavigateToSurveyDetail = {
                    val route = SurveyDestination.SurveyDetail.buildDestination(
                        surveyId = it,
                    )
                    navController.navigate(route = route)
                },
            )
        }

        composable(
            route = "${SurveyDestination.SurveyDetail.route}/{$SurveyIdArg}",
            arguments = SurveyDestination.SurveyDetail.arguments
        ) {
            SurveyDetailScreen(
                onNavigateToQuestion = { id, number ->
                    val route = SurveyDestination.SurveyQuestion.buildDestination(
                        surveyId = id,
                        questionNumber = number,
                    )
                    navController.navigate(route = route)
                },
                onBack = {
                    navController.navigate(destination = SurveyDestination.Up)
                },
            )
        }

        composable(
            route = "${SurveyDestination.SurveyQuestion.route}/{$SurveyIdArg}/{$QuestionNumberArg}",
            arguments = SurveyDestination.SurveyQuestion.arguments,
        ) {
            SurveyQuestionScreen(
                onClose = {
                    navController.navigate(destination = SurveyDestination.Up)
                },
            )
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

private fun NavHostController.navigate(destination: SurveyDestination) {
    when (destination) {
        is SurveyDestination.Up -> popBackStack()
        is SurveyDestination.Splash -> navigate(
            route = destination.route,
            navOptions {
                popUpTo(
                    route = SurveyDestination.Splash.route
                ) { inclusive = false }
                launchSingleTop = true
            },
        )

        else -> navigate(route = destination.route)
    }
}
