package com.example.eventsdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eventsdemo.ui.theme.EventsDemoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventsDemoTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        MainScreen()
                    }
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    myViewModel : MyViewModel = viewModel()
){

    Column(
        modifier = modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(
            modifier = modifier.padding(top = 50.dp),
            fontSize = 20.sp,
            text = "Total is ${myViewModel.total}"
        )

        TextField(
            modifier = modifier.padding(top = 30.dp),
            value = myViewModel.inputString,
            onValueChange = {myViewModel.onEvent(UIEvent.OnInput(it))},
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Number
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.3F)
            ),
            textStyle = TextStyle(color = Color.DarkGray, fontSize = 30.sp)
        )

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = { myViewModel.onEvent(UIEvent.OnSubmitClicked) },
            ) {
                Text(text = "Submit")
            }

            Button(
                onClick = {
                    myViewModel.onEvent(UIEvent.OnResetClicked)
                          },
            ) {
                Text(text = "Reset")
            }
        }

    }
}



