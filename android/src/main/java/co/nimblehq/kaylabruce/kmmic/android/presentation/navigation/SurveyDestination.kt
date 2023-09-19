package co.nimblehq.kaylabruce.kmmic.android.presentation.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

const val SurveyIdArg = "surveyId"
const val QuestionNumberArg = "questionNumber"

sealed class SurveyDestination(val route: String = "") {

    open val arguments: List<NamedNavArgument> = emptyList()

    object Up : SurveyDestination()

    object Splash : SurveyDestination("splash")

    object SignIn : SurveyDestination("sign-in")

    object Home : SurveyDestination("home")

    object SurveyDetail : SurveyDestination("survey-detail") {

        override val arguments = listOf(
            navArgument(SurveyIdArg) { type = NavType.StringType}
        )

        fun buildDestination(surveyId: String): String {
            return "${SurveyDetail.route}/$surveyId"
        }
    }

    object SurveyQuestion : SurveyDestination("survey-question") {

        override val arguments = listOf(
            navArgument(SurveyIdArg) { type = NavType.StringType},
            navArgument(QuestionNumberArg) { type = NavType.IntType},
        )

        fun buildDestination(surveyId: String, questionNumber: Int): String {
            return "${SurveyQuestion.route}/$surveyId/$questionNumber"
        }
    }
}
