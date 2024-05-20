package com.uteev.myweather.fragments

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.uteev.myweather.R
import com.uteev.myweather.application.isPermissionGranted
import com.uteev.myweather.data.ApiService
import com.uteev.myweather.databinding.FragmentMainBinding
import com.uteev.myweather.fragments.adapter.ViewPagerAdapter
import com.uteev.myweather.viewModel.MainViewModel


class MainFragment : Fragment() {

    private lateinit var pLauncher: ActivityResultLauncher<String>
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory(ApiService(this))
    }

    private val fragmentList  = listOf(
        HoursFragment.newInstance(),
        DaysFragment.newInstance()
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        showGif()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
        init()
        updateCurrentCard()
    }

    private fun permissionListener() {
        pLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            Toast.makeText(activity, "Permission is $isGranted", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkPermission() {
        if (!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
            permissionListener()
            pLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    private fun showGif() {
        val gifResource = R.drawable.ghibli_image
        binding?.let {
            Glide.with(this)
                .asGif()
                .load(gifResource)
                .into(it.imageView)
        }
    }

    private fun updateCurrentCard() {
        mainViewModel.liveDataCurrent.observe(viewLifecycleOwner) { dayItem ->
            binding?.let {
                it.tvTime.text = dayItem.time
                it.tvCity.text = dayItem.city
                it.tvCondit.text = dayItem.condition
                it.tvCurrentTemp.text = "${dayItem.currentTemp}°C"
                it.tvMaxMin.text = "${dayItem.maxTemp}°C / ${dayItem.minTemp}°C"
                loadImageUrl(dayItem.imageUrl)
            }
        }
    }


    private fun loadImageUrl(url: String) {
        Log.d("TAG", "loadImageUrl: $url")
        binding?.let {
            Glide.with(this)
                .load(url)
                .into(it.ivImage)
        }
    }

    private fun init() {
        val adapter = ViewPagerAdapter(activity as FragmentActivity, fragmentList)
        binding?.viewPager?.adapter = adapter
        binding?.let {
            TabLayoutMediator(it.tabLayout, binding!!.viewPager) { tab, position ->
                tab.text = when (position) {
                    0 -> "HOURS"
                    1 -> "DAYS"
                    else -> null
                }
            }.attach()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}