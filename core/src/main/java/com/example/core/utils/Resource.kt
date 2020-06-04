package com.example.core.utils

import com.example.core.models.ErrorResponse

data class Resource<out T>(val status: Status, val error: ErrorResponse?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(
                Status.SUCCESS,
                null
            )
        }

        fun <T> error(error: ErrorResponse, data: T?): Resource<T> {
            return Resource(
                Status.ERROR,
                error
            )
        }
    }

    enum class Status {
        SUCCESS,
        ERROR
    }
}
