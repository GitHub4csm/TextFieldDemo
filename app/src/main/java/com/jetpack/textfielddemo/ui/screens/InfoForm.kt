package com.jetpack.textfielddemo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType.Companion.Email
import androidx.compose.ui.text.input.KeyboardType.Companion.Number
import androidx.compose.ui.text.input.KeyboardType.Companion.Password
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.dp
import com.jetpack.textfielddemo.ui.widgets.InputField
import com.jetpack.textfielddemo.ui.widgets.InputPassWordField

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DisplayInfoForm(modifier: Modifier = Modifier){
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName  by rememberSaveable { mutableStateOf("") }
    var email  by rememberSaveable { mutableStateOf("") }
    var mobile    by rememberSaveable {mutableStateOf("") }
    var password    by rememberSaveable {mutableStateOf("") }
Column(modifier = modifier.padding(5.dp)) {
    val focusManager = LocalFocusManager.current
    val keyBoarManager = LocalSoftwareKeyboardController.current
    InputField(text = firstName,
               onValueChange = {firstName = it},
               modifier = Modifier.fillMaxWidth().wrapContentHeight(),
               label = {Text("First Name")},
               placeHolderText = {Text("Enter First Name")},
               imeAction = ImeAction.Next,
               keyboardType = Text,
               keyboardActions = KeyboardActions(onNext = {
                   focusManager.moveFocus(FocusDirection.Down)
               })
                )
    InputField(text = lastName,
        onValueChange = {lastName = it},
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        label = {Text("Last Name")},
        placeHolderText = {Text("Enter Last Name")},
        imeAction = ImeAction.Next,
        keyboardType = Text,
        keyboardActions = KeyboardActions(onNext = {
            focusManager.moveFocus(FocusDirection.Down)
        })
    )

    InputField(text = mobile,
        onValueChange = {mobile = it},
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        label = {Text("Mobile")},
        placeHolderText = {Text("Enter Mobile")},
        imeAction = ImeAction.Next,
        keyboardType = Number,
        keyboardActions = KeyboardActions(onNext = {
            focusManager.moveFocus(FocusDirection.Down)
        })
    )

    InputField(text = email,
        onValueChange = {email = it},
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        label = {Text("Email")},
        placeHolderText = {Text("Enter Email")},
        imeAction = ImeAction.Next,
        keyboardType = Email,
        keyboardActions = KeyboardActions(onNext = {
            focusManager.moveFocus(FocusDirection.Down)
        })
    )
    InputPassWordField(text = password,
        onValueChange = {password = it},
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        label = {Text("Password")},
        placeHolderText = {Text("Enter Password")},
        imeAction = ImeAction.Next,
        keyboardType = Password,
        keyboardActions = KeyboardActions(onNext = {
            focusManager.moveFocus(FocusDirection.Down)
        })
    )
    
}
}


//  keyboardActions = KeyboardActions(onDone = {
//            keyBoarManager?.hide()
//        })