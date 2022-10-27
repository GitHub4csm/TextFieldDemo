package com.jetpack.textfielddemo.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun InputField(text:String = "",
                        modifier: Modifier = Modifier,
                        placeHolderText:@Composable (() -> Unit)? = null,
                        label:@Composable (() -> Unit)? = null,
                        leadingIcon: @Composable (() -> Unit)? = null,
                        trailingIcon: @Composable (() -> Unit)? = null,
                        onValueChange: (String) -> Unit,
                        visualTransformation: VisualTransformation = VisualTransformation.None,
                        imeAction: ImeAction = ImeAction.Default,
                        keyboardType: KeyboardType = KeyboardType.Text,
                        keyboardActions: KeyboardActions = KeyboardActions(),
) {

    OutlinedTextField(value = text,
        onValueChange = onValueChange ,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        label = label,
        placeholder = placeHolderText,
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(imeAction = imeAction, keyboardType = keyboardType),
        keyboardActions = keyboardActions,
        )

}

@Composable
fun InputPassWordField(text:String = "",
               modifier: Modifier = Modifier,
               placeHolderText:@Composable (() -> Unit)? = null,
               label:@Composable (() -> Unit)? = null,
               trailingIcon: @Composable (() -> Unit)? = null,
               onValueChange: (String) -> Unit,
               visualTransformation: VisualTransformation = VisualTransformation.None,
               imeAction: ImeAction = ImeAction.Default,
               keyboardType: KeyboardType = KeyboardType.Text,
               keyboardActions: KeyboardActions = KeyboardActions(),
) {
    var showPassword = rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        label = label,
        placeholder = placeHolderText,
        leadingIcon = {
            IconButton(onClick = { showPassword.value = !showPassword.value}) {
                Icon(
                    imageVector = if (showPassword.value)
                        Icons.Filled.Visibility
                    else
                        Icons.Filled.VisibilityOff,contentDescription = "Password Validation"
                )
            }

        },
        visualTransformation = if (showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(imeAction = imeAction, keyboardType = keyboardType),
        keyboardActions = keyboardActions,
    )

}

/*
leadingIcon = IconButton(onClick = { showPassword.value = !showPassword.value}) {
            Icon(
                imageVector = if (showPassword.value)
                    Icons.Filled.Visibility
                else
                    Icons.Filled.VisibilityOff,contentDescription = "Password Validation"
            )
        },
 */