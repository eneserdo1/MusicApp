package com.app.musicapp.data.localDataSource

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager.getDefaultSharedPreferences

class SharedPreferencesHelper private constructor(context: Context) {

    private val mPreferences: SharedPreferences = getDefaultSharedPreferences(context)

    private val mEditor: SharedPreferences.Editor = mPreferences.edit()

    companion object {

        private var instance: SharedPreferencesHelper? = null


        const val LAST_UPDATE_DATE: String = "LAST_UPDATE_DATE"


        fun getInstance(context: Context): SharedPreferencesHelper {
            if (instance == null)
                instance = SharedPreferencesHelper(context)
            return instance as SharedPreferencesHelper
        }
    }
    var lastUpdateDate: String
        get() = mPreferences.getString(LAST_UPDATE_DATE, "")!!
        set(value) {
            mEditor.putString(LAST_UPDATE_DATE, value)
            mEditor.commit()
        }

    fun clear() {
        mEditor.clear()
        mEditor.commit()
    }


}