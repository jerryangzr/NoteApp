package com.example.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteapp.screens.NoteScreen
import com.example.noteapp.screens.NoteScreenPreview
import com.example.noteapp.screens.NoteScreenViewModel
import com.example.noteapp.ui.theme.NoteAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteAppTheme {
//                val viewModel = viewModel<NoteScreenViewModel>()
                val viewModel: NoteScreenViewModel by viewModels()
                NotesApp(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun NotesApp(viewModel: NoteScreenViewModel) {
    val noteLists = viewModel.noteList.collectAsState().value
    NoteScreen(
        notes = noteLists,
        onAddNote = { viewModel.addNote(it) },
        onDeleteNote = { viewModel.deleteNote(it) }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteAppTheme {
        NoteScreenPreview()
    }
}