package com.screening.screeningtest.utils

sealed class MainStateEvent {
    object GetGuestEvent: MainStateEvent()
    object None: MainStateEvent()
}
