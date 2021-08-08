package com.vaibhav.weathertask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vaibhav.weathertask.databinding.ItemWeatherBinding
import java.util.*

class WeatherAdapter(var dataList : ArrayList<WeatherModel>) : RecyclerView.Adapter<WeatherAdapter.Layout>() {

    class Layout(val binding : ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Layout {
    return Layout(ItemWeatherBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: Layout, position: Int) {
   // holder.binding.tvHour.setText(dataList[position].hour.toString())
    holder.binding.tvTemp.setText(dataList[position].main.temp.toString())
    holder.binding.tvHumid.setText(dataList[position].main.humidity.toString())
    holder.binding.tvWind.setText(dataList[position].wind.speed.toString())
    }
}