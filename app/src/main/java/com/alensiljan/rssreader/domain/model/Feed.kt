package com.alensiljan.rssreader.domain.model

data class Feed(
    val feedUrl: String,
    val feedTitle: String,
    val feedDescription: String,
    val thumbnailUrl: String
)
