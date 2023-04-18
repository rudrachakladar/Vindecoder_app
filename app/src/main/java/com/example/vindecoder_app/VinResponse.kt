package com.example.vindecoder_app

data class VinResponse(
    val Count: Int,
    val Message: String,
    val Results: List<Result>,
    val SearchCriteria: String
)