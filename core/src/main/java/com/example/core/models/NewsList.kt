package com.example.core.models

data class NewsList(
    var status: String,
    var totalResult: Int,
    var articles: List<Article>
)