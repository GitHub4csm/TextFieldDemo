package com.jetpack.textfielddemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.jetpack.textfielddemo.ui.screens.DisplayInfoForm
import com.jetpack.textfielddemo.ui.theme.TextFieldDemoTheme
import com.jetpack.textfielddemo.ui.widgets.InputField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   // Greeting("Android")
                    //DisplayOutLinedTextField()
                    DisplayInfoForm()
                }
            }
        }
    }
}

@Composable
fun DisplayOutLinedTextField(){
    var input by rememberSaveable { mutableStateOf("Hello") }
    InputField(input,
                        placeHolderText = {Text("PlaceHolder")},
                         label = {Text("Label")},
                         onValueChange = {input = it},
                         imeAction = ImeAction.Next,
                         keyboardType = KeyboardType.Number
                         )

}




@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextFieldDemoTheme {
       // Greeting("Android")
        DisplayInfoForm()
    }
}