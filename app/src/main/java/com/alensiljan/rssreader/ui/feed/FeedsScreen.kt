package com.alensiljan.rssreader.ui.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
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
            Row(verticalAlignment = Alignment.CenterVertically) {
//                Image(painter = painterResource(id = R.drawable.picture_frame), contentDescription = "")
                Column {
                    Text("The New York TIme")
                    Text("The New York Times aims to create a space where...")
                }
            }
        }
    )
}

@Preview
@Composable
fun RssFeedsPreview() {
    RssFeeds()
}