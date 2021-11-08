package com.mousavi.composesearchview

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    private var _searchBarState = mutableStateOf(SearchStatus.Closed)
    val searchBarState: State<SearchStatus> = _searchBarState

    private var _searchBarText = mutableStateOf("")
    val searchBarText: State<String> = _searchBarText

    private var _showToast = MutableSharedFlow<String>()
    val showToast: SharedFlow<String> = _showToast


    fun onSearch(query: String) {
        viewModelScope.launch {
            _showToast.emit(query)
        }
    }

    fun onTextChanged(newText: String){
        _searchBarText.value = newText
    }

    fun onEvent(status: SearchStatus) {
        _searchBarState.value = status
    }

}