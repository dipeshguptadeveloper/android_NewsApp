package com.dkgtech.newsapp.models

data class NewsModel(
    val articles: List<ArticleModel>,
    val totalResults: Int
)

data class ArticleModel(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val sourceModel: SourceModel,
    val title: String,
    val url: String,
    val urlToImage: String
)

data class SourceModel(
    val id: String,
    val name: String
)