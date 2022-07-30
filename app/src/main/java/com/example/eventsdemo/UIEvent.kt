package com.example.eventsdemo

sealed class UIEvent {
    data class OnInput(val input: String) : UIEvent()
    object OnSubmitClicked : UIEvent()
    object OnResetClicked : UIEvent()
}