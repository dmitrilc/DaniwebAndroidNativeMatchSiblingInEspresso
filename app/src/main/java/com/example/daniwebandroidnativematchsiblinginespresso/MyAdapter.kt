package com.example.daniwebandroidnativematchsiblinginespresso

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val dataSet: List<SampleViewHolderUiState>)
    : RecyclerView.Adapter<MyAdapter.SampleViewHolder>() {

    class SampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textView_name)
        val textViewTitle: TextView = itemView.findViewById(R.id.textView_title)
        val textViewAge: TextView = itemView.findViewById(R.id.textView_age)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sample_viewholder, parent, false)

        return SampleViewHolder(view)
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        holder.textViewName.text = dataSet[position].name
        holder.textViewTitle.text = dataSet[position].title
        holder.textViewAge.text = "${dataSet[position].age}"
    }

    override fun getItemCount() = dataSet.size
}