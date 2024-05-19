package com.uteev.myweather.fragments.adapter.RecycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.uteev.myweather.R
import com.uteev.myweather.databinding.CardItemBinding

class WeatherAdapter : ListAdapter<WeatherModel, DayItemViewHolder>(ItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)
        return DayItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: DayItemViewHolder, position: Int) {
        val itemDay = getItem(position)
        viewHolder.bind(itemDay)
    }
}