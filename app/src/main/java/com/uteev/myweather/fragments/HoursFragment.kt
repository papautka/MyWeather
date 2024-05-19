package com.uteev.myweather.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.uteev.myweather.R
import com.uteev.myweather.databinding.FragmentHoursBinding
import com.uteev.myweather.databinding.FragmentMainBinding
import com.uteev.myweather.fragments.adapter.RecycleView.WeatherAdapter
import com.uteev.myweather.fragments.adapter.RecycleView.WeatherModel

class HoursFragment : Fragment() {
    private lateinit var binding: FragmentHoursBinding

    private lateinit var adapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRv()
    }

    private fun initRv()  {
        binding.rvHours.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter()
        binding.rvHours.adapter = adapter

        val tmpList = listOf(
            WeatherModel(
                city = "Moscow",
                time = "12:00",
                condition = "Sunny",
                currentTemp = "25",
                maxTemp = "30",
                minTemp = "20",
                imageUrl = "https://yastatic.net/weather/i/icons/funky/dark/day/22.png",
                hours = "12:00"
            ),
            WeatherModel(
                city = "Moscow",
                time = "13:00",
                condition = "Cloudy",
                currentTemp = "24",
                maxTemp = "29",
                minTemp = "19",
                imageUrl = "https://yastatic.net/weather/i/icons/funky/dark/day/23.png",
                hours = "13:00"
            ),
            WeatherModel(
                city = "Moscow",
                time = "14:00",
                condition = "Rainy",
                currentTemp = "22",
                maxTemp = "27",
                minTemp = "18",
                imageUrl = "https://yastatic.net/weather/i/icons/funky/dark/day/24.png",
                hours = "14:00"
            ),
            WeatherModel(
                city = "Moscow",
                time = "15:00",
                condition = "Snowy",
                currentTemp = "20",
                maxTemp = "25",
                minTemp = "15",
                imageUrl = "https://yastatic.net/weather/i/icons/funky/dark/day/25.png",
                hours = "15:00"
            ),
            WeatherModel(
                city = "Moscow",
                time = "16:00",
                condition = "Windy",
                currentTemp = "18",
                maxTemp = "23",
                minTemp = "13",
                imageUrl = "https://yastatic.net/weather/i/icons/funky/dark/day/26.png",
                hours = "16:00"
            ),
            WeatherModel(
                city = "Moscow",
                time = "17:00",
                condition = "Stormy",
                currentTemp = "17",
                maxTemp = "22",
                minTemp = "12",
                imageUrl = "https://yastatic.net/weather/i/icons/funky/dark/day/27.png",
                hours = "17:00"
            ),
            WeatherModel(
                city = "Moscow",
                time = "18:00",
                condition = "Foggy",
                currentTemp = "16",
                maxTemp = "21",
                minTemp = "11",
                imageUrl = "https://yastatic.net/weather/i/icons/funky/dark/day/28.png",
                hours = "18:00"
            ),
            WeatherModel(
                city = "Moscow",
                time = "19:00",
                condition = "Misty",
                currentTemp = "15",
                maxTemp = "20",
                minTemp = "10",
                imageUrl = "https://yastatic.net/weather/i/icons/funky/dark/day/29.png",
                hours = "19:00"
            ),
            WeatherModel(
                city = "Moscow",
                time = "20:00",
                condition = "Hazy",
                currentTemp = "14",
                maxTemp = "19",
                minTemp = "9",
                imageUrl = "https://yastatic.net/weather/i/icons/funky/dark/day/30.png",
                hours = "20:00"
            ),
            WeatherModel(
                city = "Moscow",
                time = "21:00",
                condition = "Overcast",
                currentTemp = "13",
                maxTemp = "18",
                minTemp = "8",
                imageUrl = "https://yastatic.net/weather/i/icons/funky/dark/day/31.png",
                hours = "21:00"
            )
        )

        // загружаем список
        adapter.submitList(tmpList)

    }
    companion object {
        @JvmStatic
        fun newInstance() = HoursFragment()
    }
}