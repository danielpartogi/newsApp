package com.example.core.models

data class ErrorResponse(
    var code: Int? = null,
    var title: String? = null,
    var message: String? = null
)