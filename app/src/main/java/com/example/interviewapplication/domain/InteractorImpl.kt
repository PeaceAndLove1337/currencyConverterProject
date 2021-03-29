package com.example.interviewapplication.domain

import com.example.interviewapplication.data.RepositoryImpl
import com.example.interviewapplication.domain.models.CurrencyModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class InteractorImpl @Inject constructor(
    private val repositoryImpl: RepositoryImpl
) : InteractorApi {
    override fun getCurrencyContent(): Single<BaseResponse<List<CurrencyModel>>> {
        return repositoryImpl.getCurrencyContent()
    }
}