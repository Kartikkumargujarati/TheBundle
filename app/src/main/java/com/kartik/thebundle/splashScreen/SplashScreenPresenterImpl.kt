package com.kartik.thebundle.splashScreen

import com.kartik.thebundle.base.RepositoryImpl

/**
 * Created by Kartik Kumar Gujarati on 4/25/18 6:34 PM
 * Copyright (c) 2018. All rights reserved.
 */
class SplashScreenPresenterImpl(private var mSplashScreenView: SplashScreenView, private val repository: RepositoryImpl) : SplashScreenPresenter {

    override fun redirectUser() {
        if (repository.isAppFirstOpen()) {
            mSplashScreenView.showOnboarding()
        } else {
            mSplashScreenView.showLoginScreen()
        }
        mSplashScreenView.finishSplashScreen()
    }
}