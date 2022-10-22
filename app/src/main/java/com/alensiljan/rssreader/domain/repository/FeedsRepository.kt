package com.alensiljan.rssreader.domain.repository

import kotlinx.coroutines.flow.Flow

//TODO define data classes and appropriate mappers
interface FeedsRepository {
    suspend fun getFeeds(): Flow<List<Pair<String, String>>>
}