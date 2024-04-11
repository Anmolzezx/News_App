package com.techmania.newsapp.models

data class NewsApiResponse (
    var status: String? = null,
    var totalResults: Int? = 0,
    var articles: List<NewsHeadlines>? = null
)
