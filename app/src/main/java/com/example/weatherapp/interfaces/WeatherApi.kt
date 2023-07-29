package com.example.weatherapp.interfaces

import com.example.weatherapp.httpdata.WeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/data/2.5/weather?lat=38.873081567755875&lon=-77.07705228664831&appid=49704fd88ea8509b73205ffbf82bc538")
    suspend fun getWeatherData() : Response<WeatherData>
}