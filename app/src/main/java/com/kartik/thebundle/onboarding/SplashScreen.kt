package com.kartik.thebundle.onboarding

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.kartik.thebundle.MainActivity
import com.kartik.thebundle.R

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen_activity)
    }

    override fun onResume() {
        super.onResume()
        if (isFirstLaunch()) {
            startActivity(Intent(this, OnBoardingActivity::class.java))
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun isFirstLaunch(): Boolean {
        val sharedPref:SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        return !sharedPref.contains("Is_First_launch")
    }
}
