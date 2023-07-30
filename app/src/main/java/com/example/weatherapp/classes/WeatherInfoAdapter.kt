package com.example.weatherapp.classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R

class WeatherInfoAdapter(private val weather_info_list:List<WeatherInfo>) : RecyclerView.Adapter<WeatherInfoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_forecast_info, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewHolder = weather_info_list[position]
        holder.dayView.text = ItemsViewHolder.day
        holder.tempView.text = ItemsViewHolder.temp.toString()
    }

    override fun getItemCount(): Int {
        return weather_info_list.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val dayView: TextView = itemView.findViewById<TextView>(R.id.weather_info_day)
        val tempView: TextView = itemView.findViewById(R.id.weather_info_temp)
    }
}