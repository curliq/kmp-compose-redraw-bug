package org.example.redraw

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController(viewModel: HelloViewModel) = ComposeUIViewController { App(viewModel) }

fun MainViewController2(viewModel: HelloViewModel) = ComposeUIViewController { Screen2(viewModel) }
