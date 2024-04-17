package com.example.weatherapp

import java.io.Serializable

data class WeatherModel(
    val name: String,
    val main:MainModel,
    val weather: List<WeatherDescModel>
) : Serializable {
    override fun toString(): String {
        return "$name \n ${main.temp} \n ${main.humidity} \n ${weather.first().description}"
    }
}

data class WeatherDescModel (
    val main: String,
    val description: String
) : Serializable

data class MainModel (
    val temp: Double,
    val feels_like: Double,
    val humidity: Int
) : Serializable
