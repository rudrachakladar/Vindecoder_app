package com.example.vindecoder_app

data class VinDetails(
    val Count: Int,
    val Message: String,
    val Results: List<Result>,
    val SearchCriteria: String
)