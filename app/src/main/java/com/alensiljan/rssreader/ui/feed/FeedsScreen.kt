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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alensiljan.rssreader.ui.theme.Teal200

@Composable
fun RssFeeds() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "RSS feeds") },
                backgroundColor = Teal200
            )
        },
        content = {
            //TODO connect with viewModel getFeeds
            FeedsList(
                listOf(
                    Pair("The NY Times", "The New York Times aims to create a space where..."),
                    Pair("BBC News", "Get latest news"),
                    Pair("BBC Sport", "Get latest sport news")
                )
            )
        }
    )
}

@Composable
private fun FeedsList(feeds: List<Pair<String, String>>) {
    LazyColumn {
        items(feeds) { feed ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(12.dp)
            ) {
//                Image(painter = painterResource(id = R.drawable.picture_frame), contentDescription = "")
                Column {
                    Text(feed.first)
                    Text(feed.second)
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