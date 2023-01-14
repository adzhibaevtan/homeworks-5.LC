package com.love.homeworks.data.local.sharedPref

import android.content.SharedPreferences
import com.love.homeworks.preference.Constants.HAS_USER_SEEN_ON_BOARDING

class PreferencesManager(private val sharedPreferences: SharedPreferences){
    var hasUserSeenOnBoarding: Boolean
        get() = sharedPreferences.getBoolean(HAS_USER_SEEN_ON_BOARDING, false)
        set(value) = sharedPreferences.put(HAS_USER_SEEN_ON_BOARDING, value)
}