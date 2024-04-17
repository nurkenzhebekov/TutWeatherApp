package com.example.weatherapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: WeatherApi) {

    fun getWeather(city: String, livedata: MutableLiveData<WeatherModel>) {
        api.getWeather(city = city).enqueue(object : Callback<WeatherModel> {
            override fun onResponse(p0: Call<WeatherModel>, response: Response<WeatherModel>) {
                if (response.isSuccessful) {
                    response.body().let {
                        livedata.postValue(it)
                    }
                }
            }

            override fun onFailure(p0: Call<WeatherModel>, p1: Throwable) {
                Log.e("loge", "onFailure: ${p1.message}", )
            }
        })
    }
}