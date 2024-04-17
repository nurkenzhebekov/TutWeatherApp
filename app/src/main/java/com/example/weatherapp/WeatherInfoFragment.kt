package com.example.weatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weatherapp.databinding.FragmentWeatherInfoBinding

class WeatherInfoFragment : Fragment(R.layout.fragment_weather_info) {

    private val binding: FragmentWeatherInfoBinding by viewBinding()
    private val args: WeatherInfoFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvResult.text = args.weather.toString()
    }
}