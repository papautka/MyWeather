package com.uteev.myweather.fragments.adapter.RecycleView

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uteev.myweather.R
import com.uteev.myweather.databinding.CardItemBinding

class DayItemViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
    val binding : CardItemBinding = CardItemBinding.bind(view)
    fun bind(item: WeatherModel) = with(binding) {
        tvDateElem.text = item.time
        tvConditionsElem.text = item.condition
        tvTempElem.text = item.currentTemp
    }
}