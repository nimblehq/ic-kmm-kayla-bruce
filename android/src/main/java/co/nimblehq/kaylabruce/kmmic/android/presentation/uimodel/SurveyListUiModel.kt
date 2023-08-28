package co.nimblehq.kaylabruce.kmmic.android.presentation.uimodel

data class SurveyListUiModel(
    val surveys: List<SurveyUiModel>,
)

data class SurveyUiModel(
    val url: String,
    val title: String,
    val description: String,
)
