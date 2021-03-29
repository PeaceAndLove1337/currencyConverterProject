package com.example.interviewapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.interviewapplication.domain.BaseResponse
import com.example.interviewapplication.domain.InteractorImpl
import com.example.interviewapplication.domain.models.CurrencyModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val interactor: InteractorImpl
) : ViewModel() {

    private val innerLiveData = MutableLiveData<BaseResponse<List<CurrencyModel>>>()
    val outerLiveData: LiveData<BaseResponse<List<CurrencyModel>>> = innerLiveData

    fun loadContent() {
        interactor.getCurrencyContent()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { it ->
                innerLiveData.value = it
            }
    }
}