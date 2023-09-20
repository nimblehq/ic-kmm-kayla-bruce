package co.nimblehq.kaylabruce.kmmic.domain.usecase

import co.nimblehq.kaylabruce.kmmic.domain.model.Survey
import co.nimblehq.kaylabruce.kmmic.domain.model.Token
import co.nimblehq.kaylabruce.kmmic.domain.repository.AuthRepository
import co.nimblehq.kaylabruce.kmmic.domain.repository.SurveyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

interface GetSurveyListUseCase {
    operator fun invoke(
        pageNumber: Int,
        pageSize: Int,
    ): Flow<List<Survey>>
}

class GetSurveyListUseCaseImpl(private val repository: SurveyRepository) : GetSurveyListUseCase {
    override fun invoke(
        pageNumber: Int,
        pageSize: Int,
    ): Flow<List<Survey>> {
        return repository.getSurveyList(
            pageNumber = pageNumber,
            pageSize = pageSize,
        )
    }
}
