package com.example.weatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weatherapp.databinding.FragmentWeatherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment(R.layout.fragment_weather) {

    private val binding : FragmentWeatherBinding by viewBinding()
    private val viewModel : WeatherViewModel by viewModels()
    lateinit var weatherModel: WeatherModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
        observe()
    }

    private fun observe() {
        viewModel.weatherMutableLiveData.observe(viewLifecycleOwner, Observer {
            binding.tvCity.text = it.name
            weatherModel = it
        })
    }

    private fun initClickers() {
        with(binding) {
            btRequest.setOnClickListener {
                viewModel.getWeather(edtCity.text.toString())
            }
            btDetail.setOnClickListener {
                val action = WeatherFragmentDirections.actionWeatherFragmentToWeatherInfoFragment(weatherModel)
                findNavController().navigate(action)
            }
        }
    }
}