package com.jetpack.textfielddemo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType.Companion.Email
import androidx.compose.ui.text.input.KeyboardType.Companion.Number
import androidx.compose.ui.text.input.KeyboardType.Companion.Password
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.dp
import com.jetpack.textfielddemo.ui.widgets.textField.BasicTextField
import com.jetpack.textfielddemo.ui.widgets.textField.DatePickerTextField
import com.jetpack.textfielddemo.ui.widgets.textField.ErrorTextField
import com.jetpack.textfielddemo.ui.widgets.textField.PassWordTextField

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DisplayInfoForm(modifier: Modifier = Modifier){
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName  by rememberSaveable { mutableStateOf("") }
    var email  by rememberSaveable { mutableStateOf("") }
    var mobile    by rememberSaveable {mutableStateOf("") }
    var password    by rememberSaveable {mutableStateOf("") }
    var selectedDate by rememberSaveable {mutableStateOf("") }

Column(modifier = modifier.padding(5.dp)) {
    val focusManager = LocalFocusManager.current
    val keyBoarManager = LocalSoftwareKeyboardController.current
    BasicTextField(text = firstName,
               onValueChange = {firstName = it},
               modifier = Modifier
                   .fillMaxWidth()
                   .wrapContentHeight(),
               label = {Text("First Name")},
               placeHolderText = {Text("Enter First Name")},
               imeAction = ImeAction.Next,
               keyboardType = Text,
               keyboardActions = KeyboardActions(onNext = {
                   focusManager.moveFocus(FocusDirection.Down)
               }),
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color.Green, unfocusedBorderColor = Color.Red)
                )
    BasicTextField(text = lastName,
        onValueChange = {lastName = it},
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        label = {Text("Last Name")},
        placeHolderText = {Text("Enter Last Name")},
        imeAction = ImeAction.Next,
        keyboardType = Text,
        keyboardActions = KeyboardActions(onNext = {
            focusManager.moveFocus(FocusDirection.Down)
        })
    )

    ErrorTextField(text = mobile,
        onValueChange = {mobile = it},
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        label = {Text("Mobile")},
        placeHolderText = {Text("Enter Mobile")},
        imeAction = ImeAction.Next,
        keyboardType = Number,
        keyboardActions = KeyboardActions(onNext = {
            focusManager.moveFocus(FocusDirection.Down)
        }),
        isError = mobile.length < 5 && mobile.isNotBlank(),
        errorMessage = "Mobile Number is invalid. To be greater than 5"
    )

    BasicTextField(text = email,
        onValueChange = {email = it},
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        label = {Text("Email")},
        placeHolderText = {Text("Enter Email")},
        imeAction = ImeAction.Next,
        keyboardType = Email,
        keyboardActions = KeyboardActions(onNext = {
            focusManager.moveFocus(FocusDirection.Down)
        })
    )
    PassWordTextField(text = password,
        onValueChange = {password = it},
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        label = {Text("Password")},
        placeHolderText = {Text("Enter Password")},
        imeAction = ImeAction.Next,
        keyboardType = Password,
        keyboardActions = KeyboardActions(onNext = {
            focusManager.moveFocus(FocusDirection.Down)
        })
    )

    DatePickerTextField(text = selectedDate ,
                        onValueChange ={selectedDate = it},
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        label = {Text("Select  Date")},
        placeHolderText = {Text("Date Selector")},
        imeAction = ImeAction.Next,
        keyboardActions = KeyboardActions(onNext = {
            focusManager.moveFocus(FocusDirection.Down)
        }))
    
}
}


//  keyboardActions = KeyboardActions(onDone = {
//            keyBoarManager?.hide()
//        })