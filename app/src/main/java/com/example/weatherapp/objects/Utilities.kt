package com.example.weatherapp.objects

object Utilities {
    fun convertKelvinToCelsius(temp_in_kelvin:Float):Float{
        return temp_in_kelvin - 273.15.toFloat()
    }
}