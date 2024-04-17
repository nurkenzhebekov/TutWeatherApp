package com.example.weatherapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
//https://api.openweathermap.org/data/2.5/weather?appid=36cbf21e77603d1848c9293fd5e5ba31&q=Bishkek
    @GET("data/2.5/weather")
    fun getWeather(@Query("appid")key: String = "36cbf21e77603d1848c9293fd5e5ba31",
                   @Query("units")unit: String = "metric",
                   @Query("q")city: String,
    ): Call<WeatherModel>
}