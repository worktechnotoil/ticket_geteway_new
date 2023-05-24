package com.technotoil.ticket.util

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.technotoil.ticket.util.AppPreference.clearAllPreferences

object IntentHandler {
    private const val NAVIGATION_DATA = 123456

    fun backPressedAnim(activity: Activity) {
        activity.finish()
    }

    fun openActivity(activity: Activity, aClass: Class<*>?) {
        val intent = Intent(activity, aClass)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        activity.startActivity(intent)
    }

    fun openActivityWithClearBackground(activity: Activity, aClass: Class<*>?) {
        val intent = Intent(activity, aClass)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        activity.startActivity(intent)
    }

    fun openActivityWithClearBackground(activity: Activity, bundle: Bundle?, aClass: Class<*>?) {
        val intent = Intent(activity, aClass)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        intent.putExtras(bundle!!)
        activity.startActivity(intent)
    }

    fun openActivity(activity: Activity, bundle: Bundle?, aClass: Class<*>?) {
        val intent = Intent(activity, aClass)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.putExtras(bundle!!)
        activity.startActivity(intent)
    }

    fun openActivityForResult(activity: Activity, bundle: Bundle?, aClass: Class<*>?) {
        val intent = Intent(activity, aClass)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.putExtras(bundle!!)
        activity.startActivityForResult(intent, NAVIGATION_DATA)
    }

    fun logout(activity: Activity, cc: Class<*>?) {
        clearAllPreferences(activity)
        val intent = Intent(activity, cc)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        activity.startActivity(intent)
        activity.finish()
    }

    fun logout(activity: Activity, bundle: Bundle?, cc: Class<*>?) {
        clearAllPreferences(activity)
        val intent = Intent(activity, cc)
        intent.putExtras(bundle!!)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        activity.startActivity(intent)
        activity.finish()
    }
}