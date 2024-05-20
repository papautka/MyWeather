package com.uteev.myweather.fragments

import android.Manifest
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.uteev.myweather.R
import com.uteev.myweather.application.isPermissionGranted
import com.uteev.myweather.databinding.ActivityMainBinding
import com.uteev.myweather.databinding.FragmentMainBinding
import com.uteev.myweather.fragments.adapter.ViewPagerAdapter


class MainFragment : Fragment() {


    // для того чтобы выводить окно для пользователя при разрешении на получение геопозиции
    // string - разрешение
    private lateinit var pLauncher: ActivityResultLauncher<String>

    private val fragmentList  = listOf(
        HoursFragment.newInstance(),
        DaysFragment.newInstance()
    )
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        val gifResource = R.drawable.ghibli_image
        binding?.let {
            Glide.with(this)
                .asGif()
                .load(gifResource)
                .into(it.imageView)
        }

        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
        init()
    }

    private fun permissionListener() {
        pLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {
            if (it) {
                Toast.makeText(activity, "Permission is $it", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(activity, "Permission is $it", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun checkPermission() {
        if(!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
            permissionListener()
            pLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    private fun init() {
        val adapter = ViewPagerAdapter(activity as FragmentActivity, fragmentList)
        binding?.viewPager?.adapter = adapter
        binding?.let {
            TabLayoutMediator(it.tabLayout, binding!!.viewPager) {
                tab, poistion->
                when(poistion) {
                    0 -> tab.text = "HOURS"
                    1 -> tab.text = "DAYS"
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