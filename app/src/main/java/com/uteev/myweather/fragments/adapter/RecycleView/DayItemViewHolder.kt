package com.uteev.myweather.fragments.adapter.RecycleView

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uteev.myweather.R

class DayItemViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
    val dateElem = view.findViewById<TextView>(R.id.tvDateElem)
    val conditionsElem = view.findViewById<TextView>(R.id.tvConditionsElem)
    val tempElem = view.findViewById<TextView>(R.id.tvTempElem)
    val condElem = view.findViewById<ImageView>(R.id.ivCondElem)
}