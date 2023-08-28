package co.nimblehq.kaylabruce.kmmic.android.presentation.uimodel

data class SurveyQuestionUiModel(
    val imageUrl: String,
    val questionNumber: Int,
    val totalQuestion: Int,
    val questionTitle: String,
    val isLastQuestion: Boolean,
) {
    val questionIndex: String
        get() =  "$questionNumber/$totalQuestion"
}
