// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App(viewModelOne: ViewModelOne) {
    val showComposable by viewModelOne.stateOne.collectAsState()

    MaterialTheme {
        // Depending on the state we decide to create different ViewModel
        val viewModelTwo: ViewModelTwo = when (showComposable) {
            0 -> ViewModelTwo(mutableListOf("text1", "text2", "text3"))
            1 -> ViewModelTwo(mutableListOf("text4"))
            else -> ViewModelTwo(mutableListOf("blah1", "blah2", "blah3"))
        }

        // New composable is always created with new ViewModelTwo that has default index of 0, yet the app still crashes
        TestComposableTwo(viewModelTwo)
        Row {
            Button(onClick = {
                viewModelOne.changeState()
            }) {
                Text("Click button below, than me")
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        val viewModelOne = ViewModelOne();
        App(viewModelOne)
    }
}
