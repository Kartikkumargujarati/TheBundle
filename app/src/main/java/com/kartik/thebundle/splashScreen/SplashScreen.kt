package com.kartik.thebundle.splashScreen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import com.kartik.thebundle.MainActivity
import com.kartik.thebundle.R
import com.kartik.thebundle.base.RepositoryImpl
import com.kartik.thebundle.onboarding.OnBoardingActivity
import android.view.WindowManager

class SplashScreen : AppCompatActivity(), SplashScreenView {

    private lateinit var presenter: SplashScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen_activity)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        presenter = SplashScreenPresenterImpl(this, RepositoryImpl(PreferenceManager.getDefaultSharedPreferences(this)))
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({
            presenter.redirectUser()
        }, 4000)
    }

    override fun showOnboarding() {
        startActivity(Intent(this@SplashScreen, OnBoardingActivity::class.java))
    }

    override fun showLoginScreen() {
        startActivity(Intent(this@SplashScreen, MainActivity::class.java))
    }

    override fun finishSplashScreen() {
        finish()
    }
}
