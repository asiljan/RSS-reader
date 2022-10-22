package com.alensiljan.rssreader.di

import com.alensiljan.rssreader.ui.feed.FeedViewModel
import org.koin.dsl.module

val repositoriesModule = module {
    factory { FeedViewModel(get()) }
}