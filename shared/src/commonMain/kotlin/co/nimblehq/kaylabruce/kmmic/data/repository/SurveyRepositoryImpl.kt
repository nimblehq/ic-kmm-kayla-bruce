package co.nimblehq.kaylabruce.kmmic.data.repository

import co.nimblehq.kaylabruce.kmmic.data.extension.flowTransform
import co.nimblehq.kaylabruce.kmmic.data.remote.model.response.toSurvey
import co.nimblehq.kaylabruce.kmmic.data.remote.service.SurveyService
import co.nimblehq.kaylabruce.kmmic.domain.model.Survey
import co.nimblehq.kaylabruce.kmmic.domain.repository.SurveyRepository
import kotlinx.coroutines.flow.Flow

class SurveyRepositoryImpl(
    private val surveyRemoteDataSource: SurveyService,
) : SurveyRepository {
    override fun getSurveyList(
        pageNumber: Int,
        pageSize: Int,
    ): Flow<List<Survey>> = flowTransform {
        surveyRemoteDataSource
            .getSurveyList(
                pageNumber = pageNumber,
                pageSize = pageSize,
            )
            .map {
                val surveys = it
                surveys.toSurvey()
            }
    }
}
