package com.alensiljan.rssreader.ui.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alensiljan.rssreader.domain.repository.FeedsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class FeedViewState(
    val isLoading: Boolean = false,
    val activeFeeds: List<Pair<String, String>> = emptyList()
)

sealed class UIFeedIntent {
    object FetchRssFeeds : UIFeedIntent()
}

class FeedViewModel(private val feedsRepository: FeedsRepository): ViewModel() {

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

            feedsRepository.getFeeds()
                .collect{
                   _uiState.value =
                       _uiState.value.copy(isLoading = false, activeFeeds = it)
                }
        }
    }
}