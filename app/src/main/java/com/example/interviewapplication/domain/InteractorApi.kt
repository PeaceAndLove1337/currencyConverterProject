package com.example.interviewapplication.domain

import com.example.interviewapplication.domain.models.CurrencyModel
import io.reactivex.rxjava3.core.Single

interface InteractorApi {
    fun getCurrencyContent(): Single<BaseResponse<List<CurrencyModel>>>
}