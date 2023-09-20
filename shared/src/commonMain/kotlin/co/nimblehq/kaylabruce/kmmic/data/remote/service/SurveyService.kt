package co.nimblehq.kaylabruce.kmmic.data.remote.service

import co.nimblehq.kaylabruce.kmmic.data.remote.model.response.SurveyResponse

interface SurveyService {
    suspend fun getSurveyList(
        pageNumber: Int,
        pageSize: Int,
    ): List<SurveyResponse>
}

class SurveyServiceImpl(private val apiClient: ApiClient) : SurveyService {
    override suspend fun getSurveyList(
        pageNumber: Int,
        pageSize: Int
    ): List<SurveyResponse> {
        return apiClient.get<List<SurveyResponse>>(
            path = "api/v1/surveys?page[number]=$pageNumber&page[size]=$pageSize"
        )
    }
}
