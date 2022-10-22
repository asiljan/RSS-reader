package com.alensiljan.rssreader.data.converter

import com.alensiljan.rssreader.data.model.ApiFeed
import com.alensiljan.rssreader.domain.model.Feed

interface FeedModelConverter {
    fun dataToDomain(feed: ApiFeed): Feed
}

internal class FeedModelConverterImpl() : FeedModelConverter {
    override fun dataToDomain(feed: ApiFeed): Feed {
        return Feed(
            feedUrl = feed.url,
            feedTitle = feed.title,
            feedDescription = feed.description,
            thumbnailUrl = feed.thumbnailUrl
        )
    }
}