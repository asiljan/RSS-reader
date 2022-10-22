package com.alensiljan.rssreader.ui.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alensiljan.rssreader.domain.model.Feed
import com.alensiljan.rssreader.ui.theme.Teal200
import org.koin.androidx.compose.getViewModel

@Composable
fun RssFeeds(viewModel: FeedViewModel = getViewModel()) {

    LaunchedEffect(Unit) {
        viewModel.onUIIntent(UIFeedIntent.FetchRssFeeds)
    }

    val uiState = viewModel.uiState.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "RSS feeds") },
                backgroundColor = Teal200
            )
        },
        content = {
            //TODO connect with viewModel getFeeds
            FeedsList(uiState.activeFeeds)
        }
    )
}

@Composable
private fun FeedsList(feeds: List<Feed>) {
    LazyColumn {
        items(feeds) { feed ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(12.dp)
            ) {
//                Image(painter = painterResource(id = R.drawable.picture_frame), contentDescription = "")
                Column {
                    Text(text = feed.feedTitle, fontSize = 17.sp)
                    Text(text = feed.feedDescription, fontSize = 14.sp)
                }
            }
        }
    }
}

@Preview
@Composable
fun RssFeedsPreview() {
    RssFeeds()
}