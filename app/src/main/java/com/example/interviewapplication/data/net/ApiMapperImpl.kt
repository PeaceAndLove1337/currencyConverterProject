package com.example.interviewapplication.data.net

import com.example.interviewapplication.data.converter.CurrencyConverter
import com.example.interviewapplication.domain.BaseResponse
import com.example.interviewapplication.domain.models.CurrencyModel
import com.example.interviewapplication.presentation.App
import io.reactivex.rxjava3.core.Single
import okhttp3.Request

class ApiMapperImpl : ApiMapper {

    private val client = App.component.getOkHttpClient()
    private val currencyConverter = CurrencyConverter()

    override fun requestCurrencyContent(): Single<BaseResponse<List<CurrencyModel>>> {
        return Single.fromCallable {
            val request = Request
                .Builder()
                .url("https://api.exchangeratesapi.io/latest?base=RUB")
                .build()

            val response= client.newCall(request).execute()

            if (response.isSuccessful){
                BaseResponse(true, currencyConverter.convertCurrencyResponse(response), null)
            }else{
                BaseResponse(false, null, response.message)
            }


        }
    }
}