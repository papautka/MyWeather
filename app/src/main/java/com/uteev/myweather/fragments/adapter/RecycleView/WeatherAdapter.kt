package com.uteev.myweather.fragments.adapter.RecycleView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.uteev.myweather.R
import com.uteev.myweather.data.DayItem

class WeatherAdapter : ListAdapter<WeatherModel, DayItemViewHolder>(ItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayItemViewHolder {
        val layout = R.layout.card_item
        val viewDays = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return DayItemViewHolder(viewDays)
    }

    override fun onBindViewHolder(viewHolder: DayItemViewHolder, position: Int) {
        val itemDay = getItem(position)
        with(viewHolder) {
            dateElem.text = itemDay.time
            conditionsElem.text = itemDay.condition
            tempElem.text = itemDay.currentTemp
        }
    }
}