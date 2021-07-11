package com.screening.screeningtest.ui.guest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.screening.screeningtest.core.data.GuestRepository
import com.screening.screeningtest.core.data.utils.DataState
import com.screening.screeningtest.core.domain.model.Guest
import com.screening.screeningtest.utils.MainStateEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GuestViewModel @Inject constructor(private val guestRepository: GuestRepository): ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Guest>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Guest>>>
    get() = _dataState

    @ExperimentalCoroutinesApi
    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when(mainStateEvent) {
                is MainStateEvent.GetGuestEvent -> {
                    guestRepository.getGuests()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
                is MainStateEvent.None -> {
                    // ok
                }
            }
        }
    }
}
