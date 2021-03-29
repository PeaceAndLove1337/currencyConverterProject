package com.example.interviewapplication.data

import com.example.interviewapplication.domain.BaseResponse
import com.example.interviewapplication.domain.models.CurrencyModel
import io.reactivex.rxjava3.core.Single

interface RepositoryApi {

    fun getCurrencyContent(): Single<BaseResponse<List<CurrencyModel>>>
}