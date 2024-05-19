package com.uteev.myweather

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.uteev.myweather.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.bGet.setOnClickListener {
            getResult("Tashkent")
        }
    }

    private fun getResult(nameCity : String) {
        val BASE_URL = "https://api.weatherapi.com/v1/"
        val API_KEY = "90003910355246fcbb182615241905"
        val url = BASE_URL +
                "current.json" +
                "?key=" +
                API_KEY +
                "&q=" +
                nameCity +
                "&aqi=no"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            {
                response->
                Log.d("Response",response)
            },{
                Log.d("Error",it.toString())
            }
        )
        queue.add(stringRequest)
    }
}