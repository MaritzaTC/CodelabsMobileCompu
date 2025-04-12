package com.udea.keyb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.udea.keyb.ui.theme.KeybTheme // Cambia según tu proyecto

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KeybTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InputFieldsScreen()
                }
            }
        }
    }
}

@Composable
fun InputFieldsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        PasswordTextField()
        EmailTextField()
        NumberTextField()
        AutoCorrectTextField()
        NoKeyboardOnFocusField()
    }
}

@Composable
fun PasswordTextField() {
    var password by rememberSaveable { mutableStateOf("") }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun EmailTextField() {
    var email by rememberSaveable { mutableStateOf("") }

    TextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun NumberTextField() {
    var number by rememberSaveable { mutableStateOf("") }

    TextField(
        value = number,
        onValueChange = { number = it },
        label = { Text("Number") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun AutoCorrectTextField() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Auto-correct text") },
        keyboardOptions = KeyboardOptions(autoCorrect = true),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun NoKeyboardOnFocusField() {
    var value by rememberSaveable { mutableStateOf("") }

    TextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("No Keyboard on Focus") },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Words,
            showKeyboardOnFocus = false,
            keyboardType = KeyboardType.Text
        ),
        modifier = Modifier.fillMaxWidth()
    )
}