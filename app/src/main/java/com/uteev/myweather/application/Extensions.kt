package com.uteev.myweather.application

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.isPermissionGranted(permission: String) : Boolean{
    val checkSelfResult = ContextCompat.checkSelfPermission(
        activity as AppCompatActivity,
        permission
    )
    if (checkSelfResult == PackageManager.PERMISSION_GRANTED) {
        return true
    } else {
        return false
    }
}