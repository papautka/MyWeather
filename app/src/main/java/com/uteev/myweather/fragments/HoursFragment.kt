package com.uteev.myweather.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.uteev.myweather.R
import com.uteev.myweather.data.ApiService
import com.uteev.myweather.databinding.FragmentHoursBinding
import com.uteev.myweather.fragments.adapter.RecycleView.WeatherAdapter
import com.uteev.myweather.fragments.adapter.RecycleView.WeatherModel
import com.uteev.myweather.viewModel.MainViewModel

class HoursFragment : Fragment() {
    private lateinit var binding: FragmentHoursBinding
    private lateinit var adapter: WeatherAdapter
    // Assuming ApiService is provided or created here
    // Assuming ApiService is provided or created here
//    private val apiService by lazy { ApiService(requireContext()) }
//
//    // Use the factory to create the ViewModel
//    private val model: MainViewModel by viewModels {
//        MainViewModelFactory(apiService)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRv()
//        model.liveDataList.observe(viewLifecycleOwner) { weatherList ->
//            adapter.submitList(weatherList)
//        }
    }

    private fun initRv() {
        binding.rvHours.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter()
        binding.rvHours.adapter = adapter

        // The tmpList can be used for initial debugging, but should be commented out in production
        // val tmpList = listOf(
        //     WeatherModel(...),
        //     ...
        // )
        // adapter.submitList(tmpList)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HoursFragment()
    }
}
