package com.yash.noteapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yash.noteapp.dao.NoteDao
import com.yash.noteapp.entity.NoteEntity
import kotlin.concurrent.Volatile

@Database(entities = arrayOf(NoteEntity::class), version = 1, exportSchema = false)
abstract class NoteDatabase:RoomDatabase(){
    abstract fun noteDao():NoteDao

    companion object{
        @Volatile
        private var INSTANCE:NoteDatabase?=null
        fun getDatabase(context: Context):NoteDatabase{
            return INSTANCE?:synchronized(this){
                val instance=Room.databaseBuilder(context.applicationContext
                    ,NoteDatabase::class.java,
                    "word_database")
                    .build()
                INSTANCE=instance
                instance
            }
        }
    }
}