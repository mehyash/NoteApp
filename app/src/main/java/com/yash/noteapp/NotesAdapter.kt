package com.yash.noteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.yash.noteapp.entity.NoteEntity

class RowClickListener {

}

class NotesAdapter(val array: List<NoteEntity>): RecyclerView.Adapter<NotesAdapter.notesViewHolder>() {
    class notesViewHolder(item:View):RecyclerView.ViewHolder(item){
        val noteid=item.findViewById<TextView>(R.id.idcard)
        val notes= item.findViewById<TextView>(R.id.notecard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.card,parent,false)
        return notesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
        val current=array[position]
        holder.noteid.text=current.id.toString()
        holder.notes.text=current.word
    }
}