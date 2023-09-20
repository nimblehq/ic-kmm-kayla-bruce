package co.nimblehq.kaylabruce.kmmic.android.presentation.uimodel

import co.nimblehq.kaylabruce.kmmic.domain.model.Survey

data class SurveyListUiModel(
    val surveys: List<SurveyUiModel>,
)

data class SurveyUiModel(
    val id: String,
    val url: String,
    val title: String,
    val description: String,
)

fun Survey.toUiModel() = SurveyUiModel(
    id = id,
    url = coverImageUrl,
    title = title,
    description = description,
)
