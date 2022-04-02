package com.example.daniwebandroidnativematchsiblinginespresso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_myRecycler)

        val sampleDataSet = listOf(
            SampleViewHolderUiState("John", "Student", 17),
            SampleViewHolderUiState("Mary", "Teacher", 28)
        )

        recyclerView.adapter = MyAdapter(sampleDataSet)
    }
}