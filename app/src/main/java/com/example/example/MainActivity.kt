package com.example.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.example.databinding.ActivityMainBinding
import com.example.example.viewmodles.NotesViewModelFactory
import com.example.example.viewmodles.NoteViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: NoteViewModel
    private lateinit var databinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val factory = NotesViewModelFactory()
        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        databinding.notesViewModel = viewModel
        databinding.lifecycleOwner = this
        viewModel.list.observe(this, Observer {
            databinding.content.text = it.toString()
        })
    }
}