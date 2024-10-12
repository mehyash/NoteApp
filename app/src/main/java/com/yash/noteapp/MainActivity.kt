package com.yash.noteapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yash.noteapp.dao.NoteDao
import com.yash.noteapp.database.NoteDatabase
import com.yash.noteapp.databinding.ActivityMainBinding
import com.yash.noteapp.entity.NoteEntity
import com.yash.noteapp.repository.NoteRepository
import com.yash.noteapp.viewmodel.NoteViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: NoteViewModel
    lateinit var repository: NoteRepository
    lateinit var rv:NotesAdapter
    lateinit var arrayList:ArrayList<NoteEntity>
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val noteDao=NoteDatabase.getDatabase(application).noteDao()
        repository= NoteRepository(noteDao)
        arrayList=ArrayList<NoteEntity>()
        binding.recyclerview.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            rv=NotesAdapter(arrayList)
            adapter=rv
        }
        viewModel=ViewModelProvider(this)[NoteViewModel::class.java]
        viewModel.allNotes.observe(this,{notes->
            arrayList.clear()
            arrayList.addAll(notes)
            rv.notifyDataSetChanged()
        })
        binding.add.setOnClickListener {
            val id=binding.id.text.toString()
            val notes=binding.note.text.toString()
            val notelist=NoteEntity(0, notes)
            GlobalScope.launch {
                repository.insert(notelist)
            }
            binding.note.text.clear()
            binding.id.text.clear()
        }
    }
}