package com.example.noteapp.repository

import com.example.noteapp.data.NoteDatabaseDao
import com.example.noteapp.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDatabaseDao: NoteDatabaseDao
){
    suspend fun addNote(note: Note) = noteDatabaseDao.addNote(note)
    suspend fun updateNote(note: Note) = noteDatabaseDao.update(note)
    suspend fun deleteNote(note: Note) = noteDatabaseDao.deleteNote(note)

    suspend fun deleteAllNotes() = noteDatabaseDao.deleteAllNotes()
    fun getNotes(): Flow<List<Note>> {
        return noteDatabaseDao.getNotes()
            .flowOn(Dispatchers.IO)
            .conflate()
    }

    suspend fun getNoteById(id: String): Note {
        return noteDatabaseDao.getNoteById(id)
    }

}