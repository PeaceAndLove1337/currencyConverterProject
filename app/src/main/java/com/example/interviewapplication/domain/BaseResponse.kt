package com.example.interviewapplication.domain

data class BaseResponse <T>(
    val isSuccessful:Boolean,
    val body: T?,
    val error:String?
    )