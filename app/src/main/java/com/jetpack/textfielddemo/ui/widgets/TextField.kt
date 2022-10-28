package com.jetpack.textfielddemo.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

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
               colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors()
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
        colors = colors
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

@Composable
fun InputErrorField(text:String = "",
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
               colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(),
               isError:Boolean = false,
               errorMessage:String = "",
) {
    Column(modifier = Modifier.padding(
        bottom = if (isError) {
            0.dp
        } else {
            10.dp
        }
    ) ) {

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
        colors = colors,
        isError = isError
    )
        if (isError){
            Text(
                text = errorMessage,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
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