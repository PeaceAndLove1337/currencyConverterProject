package com.example.interviewapplication.presentation.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.interviewapplication.R
import com.example.interviewapplication.domain.models.CurrencyModel

class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val fullName: TextView = itemView.findViewById(R.id.text_view_full_name)
    private val cutName: TextView = itemView.findViewById(R.id.text_view_cut_name)
    private val value: TextView = itemView.findViewById(R.id.text_view_value)

    fun bind(model: CurrencyModel) {
        fullName.text = model.fullNameOnRussian
        cutName.text = model.cutName
        value.text = model.value.toString()
    }
}