package co.nimblehq.kaylabruce.kmmic.android.presentation.navigation

import androidx.navigation.NamedNavArgument

sealed class SurveyDestination(val route: String = "") {

    open val arguments: List<NamedNavArgument> = emptyList()

    object Splash : SurveyDestination("splash")

    object SignIn : SurveyDestination("sign-in")

    object SurveyList : SurveyDestination("survey-list")
}
