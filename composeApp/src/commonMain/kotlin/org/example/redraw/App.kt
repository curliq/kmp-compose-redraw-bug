package org.example.redraw

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(viewModel: HelloViewModel) {
    MaterialTheme {
        val data = viewModel.data.collectAsState().value
        Column(Modifier.fillMaxWidth().background(Color.Cyan), horizontalAlignment = Alignment.CenterHorizontally) {
            println("Recompose called for screen1. Data: $data")
            Button(onClick = { }) {
                Text("do nothing")
            }
            LazyColumn {
                items(data) { data ->
                    Text(data)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun Screen2(viewModel: HelloViewModel) {
    MaterialTheme {
        val data = viewModel.data.collectAsState().value
        Column {
            println("Recompose called for screen2. Data: $data")
            Button(onClick = { viewModel.data.update { it.plus(it.count().plus(1).toString()) } }) {
                Text("Add item")
            }
            LazyColumn {
                items(data) { data ->
                    Text(data)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

class HelloViewModel {
    val data = MutableStateFlow(listOf("1"))
}
