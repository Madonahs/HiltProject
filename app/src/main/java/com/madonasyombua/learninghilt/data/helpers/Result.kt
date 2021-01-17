package com.madonasyombua.learninghilt.data.helpers


sealed class Result<out Type> {

    data class Success<out Type>(
        val data: Type,
        val resultInfo: ResultInfo? = null
    ) : Result<Type>()

    data class Error(val throwable: Throwable) : Result<Nothing>()

    object Loading : Result<Nothing>()
}

data class ResultInfo(val statusMessage: String, val statusCode: Int)