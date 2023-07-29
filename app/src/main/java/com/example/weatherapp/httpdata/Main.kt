package com.example.weatherapp.httpdata

data class Main(
    val temp:Float,
    val feels_like:Float,
    val temp_min:Float,
    val temp_max:Float,
    val pressure:Int,
    val humidity:Int,
    val sea_level:Int,
    val grn_level:Int
)
