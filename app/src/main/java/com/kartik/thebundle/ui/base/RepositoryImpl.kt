package com.kartik.thebundle.base

import android.content.SharedPreferences

/**
 * Created by Kartik Kumar Gujarati on 4/27/18 4:08 PM
 * Copyright (c) 2018. All rights reserved.
 */
class RepositoryImpl(val sharedPreferences: SharedPreferences) : Repository {

    override fun isAppFirstOpen(): Boolean {
        return !sharedPreferences.contains("Is_First_launch")
    }
}

