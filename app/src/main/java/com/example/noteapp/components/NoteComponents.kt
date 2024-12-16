package com.example.noteapp.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun NoteInputText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit = {},
    onImeAction: () -> Unit = {}
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.colors(
            Color.DarkGray
        ),
        label = { Text(label) },
        maxLines = maxLine,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
                keyboardController?.hide()
            }
        ),
        modifier = modifier
    )
}


@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    elevation: ButtonElevation = ButtonDefaults.buttonElevation(6.dp),
    onClick: () -> Unit = {}
) {
    val context = LocalContext.current
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
        elevation = elevation,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )
    ) {
        Text(text)
    }
}


fun showToast(context: Context) {
    Toast.makeText(context, "Button Clicked!!!", Toast.LENGTH_SHORT).show()
}