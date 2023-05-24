package com.technotoil.ticket.util

import android.content.Context

object AppPreference {

    private const val APP_PREFERENCE = AppConstant.APP_PREFERENCE

    fun getStringPreference(context: Context, key: String): String? {
        val preferences = context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE)
        return preferences.getString(key, "")
    }

    fun setStringPreference(context: Context, key: String, value: String?) {
        val preferences = context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }


    fun setIntegerPreference(context: Context, key: String, value: Int) {
        val preferences = context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getIntegerPreference(context: Context, key: String, defaultValue: Int): Int {
        val preferences = context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE)
        return preferences.getInt(key, defaultValue)
    }

    fun setFloatPreference(context: Context, key: String, value: Float) {
        val preferences = context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    fun getFloatPreference(context: Context, key: String): Float {
        val preferences = context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE)
        return preferences.getFloat(key, 0f)
    }

    fun setBooleanPreference(context: Context, key: String, value: Boolean) {
        val preferences = context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBooleanPreference(context: Context, key: String, defaultValue: Boolean): Boolean {
        val preferences = context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE)
        return preferences.getBoolean(key, defaultValue)
    }

    fun clearAllPreferences(context: Context) {
        val preferences = context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
    }

}