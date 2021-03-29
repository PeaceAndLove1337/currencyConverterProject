package com.example.interviewapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.interviewapplication.R
import com.example.interviewapplication.domain.models.CurrencyModel
import com.example.interviewapplication.presentation.viewholder.CurrencyViewHolder

class CurrencyRecyclerAdapter : RecyclerView.Adapter<CurrencyViewHolder>() {

    private var listItem = listOf<CurrencyModel>()

    fun setItems(items: List<CurrencyModel>) {
        listItem = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.currency_item, parent, false)
        return CurrencyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(listItem[position])
    }

    override fun getItemCount() = listItem.size
}