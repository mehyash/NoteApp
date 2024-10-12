package com.yash.noteapp.repository

import androidx.lifecycle.LiveData
import com.yash.noteapp.dao.NoteDao
import com.yash.noteapp.entity.NoteEntity

class NoteRepository(private val noteDao: NoteDao) {
    val allNote:LiveData<List<NoteEntity>> = noteDao.getNoteList()
    fun getNoteList():LiveData<List<NoteEntity>>{
        return noteDao.getNoteList()
    }
    suspend fun insert(note:NoteEntity){
        noteDao.insert(note)
    }
}