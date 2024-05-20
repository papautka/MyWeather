package com.uteev.myweather.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.uteev.myweather.data.ApiService
import com.uteev.myweather.fragments.adapter.RecycleView.WeatherModel

class MainViewModel(private val apiService: ApiService) : ViewModel() {
    val liveDataCurrent: LiveData<WeatherModel> get() = apiService.currentWeatherLiveData
    val liveDataList: LiveData<List<WeatherModel>> get() = apiService.forecastWeatherLiveData

    init {
        connectApiService()
    }

    private fun connectApiService() {
        apiService.requestWeatherData()
    }
}
