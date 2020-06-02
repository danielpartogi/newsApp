package com.example.core.models

data class SourceNewsList(
    var status: String?,
    var sources: List<SourcesNews>?
)

data class SourcesNews(
    var id: String?,
    var name: String?,
    var description: String?
)