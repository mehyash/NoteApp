package com.yash.noteapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.yash.noteapp.database.NoteDatabase
import com.yash.noteapp.entity.NoteEntity
import com.yash.noteapp.repository.NoteRepository

class NoteViewModel (application:Application):AndroidViewModel(application){
    val allNotes:LiveData<List<NoteEntity>>
    init{

        val dao = NoteDatabase.getDatabase(application).noteDao()
        val repository:NoteRepository=NoteRepository(dao)
        allNotes= repository.allNote

    }
}