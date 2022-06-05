package com.vladbstrv.dictionaryapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vladbstrv.dictionaryapp.R
import com.vladbstrv.dictionaryapp.databinding.ItemWordActivityMainBinding
import com.vladbstrv.dictionaryapp.domain.entities.WordData

class MainAdapter(private var data: List<WordData>):
    RecyclerView.Adapter<MainAdapter.RecyclerItemViewHolder>() {

    fun setData(data: List<WordData>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemViewHolder {
        val itemBinding = ItemWordActivityMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerItemViewHolder(itemBinding.root)
//        RecyclerItemViewHolder(
//            LayoutInflater.from(parent.context)
//                .inflate(R.layout.item_word_activity_main, parent, false) as View
//        )
    }

    override fun onBindViewHolder(holder: RecyclerItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class RecyclerItemViewHolder(itemBinding: View) : RecyclerView.ViewHolder(itemBinding) {

        fun bind(data: WordData) {
            ItemWordActivityMainBinding.bind(itemView).apply {
                headerTextviewRecyclerItem.text = data.text
                descriptionTextviewRecyclerItem.text = data.translate
            }
        }
    }
}