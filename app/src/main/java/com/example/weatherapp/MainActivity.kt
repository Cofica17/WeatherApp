package com.example.weatherapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.classes.WeatherInfo
import com.example.weatherapp.classes.WeatherInfoAdapter
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

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<WeatherInfo>()
        for (i in 1..20) {
            data.add(WeatherInfo("test", i))
        }
        val adapter = WeatherInfoAdapter(data)
        recyclerview.adapter = adapter
        val horizontalLayoutManagaer = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        recyclerview.setLayoutManager(horizontalLayoutManagaer)

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
        val descView = findViewById<TextView>(R.id.description)
        val highTempView = findViewById<TextView>(R.id.high_temp)
        val lowTempView = findViewById<TextView>(R.id.low_temp)

        locationView.text = weather_data.name
        tempView.text = Utilities.convertKelvinToCelsius(weather_data.main.temp).toInt().toString()+"°"
        descView.text = weather_data.weather.get(0).description
        highTempView.text = "H:"+Utilities.convertKelvinToCelsius(weather_data.main.temp_max).toInt().toString()+"°"
        lowTempView.text = "L:"+Utilities.convertKelvinToCelsius(weather_data.main.temp_min).toInt().toString()+"°"
    }
}