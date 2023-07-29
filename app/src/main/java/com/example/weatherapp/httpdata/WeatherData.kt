package com.example.weatherapp.httpdata

import java.util.*

data class WeatherData (
    val coord:Coord,
    val weather:List<Weather>,
    val base:String,
    val main:Main,
    val visibility:Int,
    val wind:Map<String, Float>,
    val rain:Map<String,Float>,
    val clouds:Map<String, Float>,
    val dt:Int,
    val sys:Sys,
    val timezone:Int,
    val id:Int,
    val name:String,
    val cod:Int
)