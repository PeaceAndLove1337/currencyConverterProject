package com.example.interviewapplication.domain

import com.example.interviewapplication.domain.models.CurrencyModel

/**
 * Преобразователь валют
 *
 *
 * @param countOfCurrencyFrom Количество валюты из которой происходит конвертация
 * @param howManyToCurrencyInUnit Количество исходной валюты в валюте в которую происходит конвертация
 * Например в 1 рубле 0.013 USD
 */
fun convertCurrency(countOfCurrencyFrom: Double, howManyToCurrencyInUnit: Double): Double {
    return countOfCurrencyFrom * howManyToCurrencyInUnit
}

/**
 * Получить список сокращённых названий валют из данного list'a валют
 *
 * @param inputList Входной список валют
 *
 */
fun takeListOfCutNames(inputList: List<CurrencyModel>): List<String> {
    return inputList.map { it.cutName }
}

/**
 * Получить значение отношения валюты по сокращённому названию
 *
 * @param inputList Входной список валют
 *@param cutName Сокращённое название валюты, отношение который мы хотим получить
 */
fun takeAttitudeByName(inputList: List<CurrencyModel>, cutName: String): Double {
    return inputList.first { it.cutName == cutName }.value
}