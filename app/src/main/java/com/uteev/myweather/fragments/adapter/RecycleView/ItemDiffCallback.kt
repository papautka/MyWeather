package com.uteev.myweather.fragments.adapter.RecycleView

import androidx.recyclerview.widget.DiffUtil
import com.uteev.myweather.data.DayItem

class ItemDiffCallback : DiffUtil.ItemCallback<WeatherModel>() {

    override fun areItemsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: WeatherModel, newItem: WeatherModel): Any? {
        return super.getChangePayload(oldItem, newItem)
    }
}