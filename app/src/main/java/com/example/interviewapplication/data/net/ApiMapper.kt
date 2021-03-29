package com.example.interviewapplication.data.net

import com.example.interviewapplication.domain.BaseResponse
import com.example.interviewapplication.domain.models.CurrencyModel
import io.reactivex.rxjava3.core.Single

interface ApiMapper {

    fun requestCurrencyContent(): Single<BaseResponse<List<CurrencyModel>>>
}