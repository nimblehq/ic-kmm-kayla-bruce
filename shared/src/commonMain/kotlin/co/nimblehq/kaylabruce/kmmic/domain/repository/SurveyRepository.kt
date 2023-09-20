package co.nimblehq.kaylabruce.kmmic.domain.repository

import co.nimblehq.kaylabruce.kmmic.domain.model.Survey
import kotlinx.coroutines.flow.Flow

interface SurveyRepository {
    fun getSurveyList(
        pageNumber: Int,
        pageSize: Int,
    ): Flow<List<Survey>>
}
