package com.jetpack.textfielddemo.ui.widgets.textField

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import java.util.Calendar
import java.util.Date

@Composable
fun DatePickerTextField(text:String,
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
   val selectedDate = rememberSaveable { mutableStateOf(text) }
   val datePickerDialog = fetchDatePickerDialog(selectedDate)
    OutlinedTextField(value = selectedDate.value,
        onValueChange = onValueChange ,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { datePickerDialog.show()  },
        label = label,
        placeholder = placeHolderText,
        readOnly = true,
        enabled = false,
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(imeAction = imeAction, keyboardType = keyboardType),
        keyboardActions = keyboardActions,
        colors = colors
    )

}
@Composable
fun fetchDatePickerDialog(selectedDate:MutableState<String>):DatePickerDialog {
    // Local Context
    val mContext = LocalContext.current
    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val mCalendar = Calendar.getInstance()
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()
    return DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            selectedDate.value = "$mDayOfMonth-${mMonth+1}-$mYear"
        }, mYear, mMonth, mDay
    )
}