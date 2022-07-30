package com.example.eventsdemo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private var _inputString by mutableStateOf("")
    val inputString : String
        get() = _inputString

    fun addInput(input:String){
        _inputString = input
    }


    private var _total by mutableStateOf(0.0)
    val total: Double
        get() = _total


    private fun addToTotal(){
        _total += inputString.toDouble()
    }

    private fun resetTotal(){
        _inputString = ""
        _total = 0.0
    }

    fun onEvent(event: UIEvent){
        when(event){
            is UIEvent.OnInput -> {addInput(event.input)}
            is UIEvent.OnSubmitClicked -> addToTotal()
            is UIEvent.OnResetClicked -> resetTotal()
        }
    }

}