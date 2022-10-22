package com.alensiljan.rssreader.data.repository

import com.alensiljan.rssreader.domain.repository.FeedsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flowOn

class LocalFeedsRepository : FeedsRepository {

    override suspend fun getFeeds(): Flow<List<Pair<String, String>>> =
        channelFlow {
            trySend(
                listOf(
                    Pair("The NY Times", "The New York Times aims to create a space where..."),
                    Pair("BBC News", "Get latest news"),
                    Pair("BBC Sport", "Get latest sport news")
                )
            )
//            awaitClose() //to keep it running
        }.flowOn(Dispatchers.IO)
}