package com.alensiljan.rssreader.di

import com.alensiljan.rssreader.data.repository.RssFeedsRepository
import com.alensiljan.rssreader.domain.repository.FeedsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<FeedsRepository> { RssFeedsRepository() }
}