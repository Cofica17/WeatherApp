package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.weatherapp.httpdata.WeatherData
import com.example.weatherapp.interfaces.WeatherApi
import com.example.weatherapp.objects.RetrofitHelper
import com.example.weatherapp.objects.Utilities
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherApi = RetrofitHelper.getInstance().create(WeatherApi::class.java)
        GlobalScope.launch {
            val result = weatherApi.getWeatherData().body()
            if(result!=null)
                runOnUiThread(Runnable {
                    kotlin.run {
                        setData(result)
                    }
                })

        }
    }

    fun setData(weather_data:WeatherData){
        val locationView = findViewById<TextView>(R.id.location_name)
        val tempView = findViewById<TextView>(R.id.temp)
        locationView.text = weather_data.name
        tempView.text = Utilities.convertKelvinToCelsius(weather_data.main.temp).toInt().toString()
    }
}