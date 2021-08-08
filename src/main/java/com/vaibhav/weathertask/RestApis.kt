package com.vaibhav.weathertask

import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface RestApis {

 @GET("/data/2.5/weather")
 fun getWeatherData(@Query("lat") lat: String,@Query("lon") lng: String,
                   @Query("lat") api_key: String) : retrofit2.Call<ArrayList<WeatherModel>>

}