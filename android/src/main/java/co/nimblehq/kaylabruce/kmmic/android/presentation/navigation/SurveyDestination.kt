package co.nimblehq.kaylabruce.kmmic.android.presentation.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

const val SurveyIdArg = "surveyId"

sealed class SurveyDestination(val route: String = "") {

    open val arguments: List<NamedNavArgument> = emptyList()

    object Splash : SurveyDestination("splash")

    object SignIn : SurveyDestination("sign-in")

    object Home : SurveyDestination("home")

    object SurveyDetail : SurveyDestination("survey-detail") {

        override val arguments = listOf(
            navArgument(SurveyIdArg) { type = NavType.StringType}
        )

        fun buildDestination(surveyId: String): String {
            return "survey/$surveyId"
        }
    }
}
