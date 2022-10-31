package com.jetpack.textfielddemo.ui.widgets.textField

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun BasicTextField(text:String = "",
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