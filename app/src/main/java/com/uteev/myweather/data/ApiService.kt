package com.uteev.myweather.data

import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.uteev.myweather.fragments.MainFragment
import com.uteev.myweather.fragments.adapter.RecycleView.WeatherAdapter
import com.uteev.myweather.fragments.adapter.RecycleView.WeatherModel
import org.json.JSONObject

class ApiService(private val context: MainFragment, private val city: String) {
    fun requestWeatherData(city: String) {
        val API_KEY = "90003910355246fcbb182615241905"
        val url = "https://api.weatherapi.com/v1/forecast.json?" +
                "key=" +
                API_KEY +
                "&q=" +
                city +
                "&days=" +
                "10" +
                "&aqi=no&alerts=no"
        val queue = Volley.newRequestQueue(context.activity)
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            {
                resultJson->
                parseWeatherData(resultJson)
                Log.d("ApiService Response",resultJson)

            },
            {
                error->
                Log.d("ApiService Error",error.toString())
            }
            )
        queue.add(stringRequest)
    }

    private fun parseWeatherData(resultJson: String) {
        val FIRST_ELEMENT = 0
        val mainObject = JSONObject(resultJson)
        val listItem = parseForecastDays(mainObject)
        val item = parseCurrentData(mainObject, listItem[FIRST_ELEMENT])
//        Log.d("listItem", listItem.toString())
        Log.d("parseWeatherData", item.toString())
    }
    private fun parseCurrentData(mainObject : JSONObject, weatherModel: WeatherModel) : WeatherModel {
        val location = mainObject.getJSONObject("location")
        val current = mainObject.getJSONObject("current")
        val condition = current.getJSONObject("condition")
        val result = WeatherModel(
            location.getString("name"),
            current.getString("last_updated"),
            condition.getString("text"),
            current.getString("temp_c"),
            weatherModel.maxTemp,
            weatherModel.minTemp,
            condition.getString("icon"),
            weatherModel.hours
        )
        return result
    }

    private fun parseForecastDays(mainObject: JSONObject) : List<WeatherModel> {
        val list = ArrayList<WeatherModel>()
        val daysArray = mainObject.getJSONObject("forecast")
            .getJSONArray("forecastday")
        for (i in 0 until daysArray.length()) {
            val forecastday = daysArray[i] as JSONObject
            val day = forecastday.getJSONObject("day")
            val condition = day.getJSONObject("condition")
            val tmpElemForList = WeatherModel(
                "",
                forecastday.getString("date"),
                condition.getString("text"),
                "",
                day.getString("maxtemp_c"),
                day.getString("mintemp_c"),
                condition.getString("icon"),
                forecastday.getJSONArray("hour").toString()
            )
            list.add(tmpElemForList)

        }
        return list
    }
}