package com.alensiljan.rssreader.domain.repository

import com.alensiljan.rssreader.domain.model.Feed
import kotlinx.coroutines.flow.Flow

//TODO appropriate mappers, data models and introduce usecases
interface FeedsRepository {
    suspend fun getFeeds(): Flow<List<Feed>>
}