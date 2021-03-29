package com.example.interviewapplication.data

import com.example.interviewapplication.data.net.ApiMapperImpl
import com.example.interviewapplication.domain.BaseResponse
import com.example.interviewapplication.domain.models.CurrencyModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiMapper: ApiMapperImpl
) : RepositoryApi {

    override fun getCurrencyContent(): Single<BaseResponse<List<CurrencyModel>>> {
        return apiMapper.requestCurrencyContent()
    }
}