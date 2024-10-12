package com.yash.noteapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)val id:Int,
    @ColumnInfo(name = "word")val word:String
)
