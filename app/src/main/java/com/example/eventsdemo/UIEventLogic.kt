package com.example.eventsdemo

class UIEventLogic(private val viewModel: MyViewModel) {

    fun onEvent(event: UIEvent){
        when(event){
          //  is UIEvent.OnInput -> {viewModel.addInput(event.input)}
          //  is UIEvent.OnSubmitClicked -> viewModel.addToTotal()
           // is UIEvent.OnResetClicked -> viewModel.resetTotal()
        }
    }
}