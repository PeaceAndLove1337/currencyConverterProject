package com.example.interviewapplication.data.converter

import com.example.interviewapplication.domain.models.CurrencyModel
import com.example.interviewapplication.presentation.App
import okhttp3.Response

class CurrencyConverter {

    fun convertCurrencyResponse(response: Response): List<CurrencyModel> {

        val responseBody = response.body!!.string()
        val objectMapper = App.component.getObjectMapper()

        val result = mutableListOf<CurrencyModel>()
        val node = objectMapper.readTree(responseBody).get("rates")
        node.fields().forEach { result.add(CurrencyModel(it.key, it.value.toString().toDouble())) }

        return result
    }
}