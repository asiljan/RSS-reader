package com.alensiljan.rssreader.data.repository

import com.alensiljan.rssreader.domain.model.Feed
import com.alensiljan.rssreader.domain.repository.FeedsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flowOn

class RssFeedsRepository : FeedsRepository {

    //TODO implement feeds service, add feed parser and converter from API model to Feed model
    override suspend fun getFeeds(): Flow<List<Feed>> =
        channelFlow {
            trySend(
                listOf(
                    Feed(
                        feedUrl = "https://rss.art19.com/apology-line",
                        feedTitle = "The Apology Line",
                        feedDescription = "Listen to The Apology Line exclusively",
                        thumbnailUrl = "https://content.production.cdn.art19.com/images/be/e1/82/c2/bee182c2-14b7-491b-b877-272ab6754025/bd4ab6d08d7b723678a682b6e399d26523245b3ba83f61617b9b28396aba1092b101cd86707576ec021b77e143b447463342b352f8825265b15310c989b6cb93.jpeg"
                    ),
                    Feed(
                        feedUrl = "https://feeds.simplecast.com/qm_9xx0g",
                        feedTitle = "Crime Junkie",
                        feedDescription = "If you can never get enough true crime...",
                        thumbnailUrl = "https://image.simplecastcdn.com/images/7d68c467-d3d7-41c3-b7c0-92218b530432/6b5d4ba2-4ba6-4137-9965-abd4e038dd95/3000x3000/crimejunkie-square-show-art.jpg"
                    ),
                    Feed(
                        feedUrl = "https://lincolnproject.libsyn.com/rss",
                        feedTitle = "The Lincoln project",
                        feedDescription = "Trump may be gone but American politics is still...",
                        thumbnailUrl = "https://ssl-static.libsyn.com/p/assets/d/c/9/6/dc96a8711b08ecf5/LINCOLN_RGB.png"
                    ),

                )
            )
//            awaitClose() //to keep it running
        }.flowOn(Dispatchers.IO)
}