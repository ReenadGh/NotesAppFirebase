package com.example.noteappfirebase2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val myViewModel by lazy { ViewModelProvider(this).get(ViewModel::class.java) }
    private lateinit var rvAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = Firebase.firestore

        rvAdapter = RecyclerViewAdapter(this)
        rvMain.adapter = rvAdapter
        rvMain.layoutManager = LinearLayoutManager(this)
        myViewModel.getNotes().observe(
            this , { Notes ->rvAdapter.update(Notes)}
        )

        addB.setOnClickListener {
            if (noteE.text.isNotEmpty()){
                myViewModel.addNote(Note("", noteE.text.toString()))


            }


        }}

}

