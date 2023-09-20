package co.nimblehq.kaylabruce.kmmic.data.remote.model.response

import co.nimblehq.kaylabruce.kmmic.domain.model.Survey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SurveyResponse(
    @SerialName("id")
    val id: String,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("cover_image_url")
    val coverImageUrl: String,
)

fun SurveyResponse.toSurvey() = Survey(
    id = id,
    title = title,
    description = description,
    coverImageUrl = coverImageUrl,
)
