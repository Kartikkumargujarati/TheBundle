package com.kartik.thebundle.onboarding

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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
        isFirstLaunch()
    }

    private fun isFirstLaunch() {
        val handler = Handler()
        val sharedPref:SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        handler.postDelayed({
            if (!sharedPref.contains("Is_First_launch")) {
                startActivity(Intent(this@SplashScreen, OnBoardingActivity::class.java))
            } else {
                startActivity(Intent(this@SplashScreen, MainActivity::class.java))
            }
            this.finish()
        }, 3000)
    }
}
