package com.example.fitnessshop.model

data class BaseResponse<T>(
    val status :String,
    val totalResults:Int,
    val articles:T
)