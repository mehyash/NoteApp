package com.yash.noteapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yash.noteapp.entity.NoteEntity

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note:NoteEntity)
    @Query("SELECT * FROM word_table")
    fun getNoteList():LiveData<List<NoteEntity>>
}