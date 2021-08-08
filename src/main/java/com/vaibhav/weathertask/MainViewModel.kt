package com.vaibhav.weathertask

import android.location.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    var weatherObserver = MutableLiveData<WeatherModel>()
    var errorObserver = MutableLiveData<String>()

fun fetchData(location: Location)
{
    RetroClass.getInstance().create(RestApis :: class.java).getWeatherData().enqueue(object : Callback<CustomerUserData> {
        override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
            errorObserver.value =  t.message
        }

        override fun onResponse(
                call: Call<WeatherModel>,
                response: Response<WeatherModel>
        ) {
            if (response.isSuccessful) {
                weatherObserver.value = response.body()
            } else {
                errorObserver.value = response.message()
            }
        }

    })
}

}