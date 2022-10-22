package com.alensiljan.rssreader.ui.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class FeedViewState(
    val isLoading: Boolean = false,
    val activeFeeds: List<Pair<String, String>> = emptyList()
)

sealed class UIFeedIntent {
    object FetchRssFeeds : UIFeedIntent()
}

class FeedViewModel: ViewModel() {
    //TODO Next step is to define data layer and provide data within the data layer
    //also, define model classes

    private val _uiState = MutableStateFlow(FeedViewState())
    val uiState: StateFlow<FeedViewState> = _uiState

    fun onUIIntent(intent: UIFeedIntent) {
        when(intent) {
            UIFeedIntent.FetchRssFeeds -> fetchRssFeeds()
        }
    }

    private fun fetchRssFeeds() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            val result = repoRssGetFeeds().getOrNull()

            _uiState.value = result?.let {
                _uiState.value.copy(isLoading = false, activeFeeds = it)
            } ?: _uiState.value.copy(isLoading = false)
        }
    }

    //TODO call repo within data layer
    private suspend fun repoRssGetFeeds(): Result<List<Pair<String, String>>> {
        return withContext(Dispatchers.IO) {
            Result.success(
                listOf(
                    Pair("The NY Times", "The New York Times aims to create a space where..."),
                    Pair("BBC News", "Get latest news"),
                    Pair("BBC Sport", "Get latest sport news")
                )
            )
        }
    }

}