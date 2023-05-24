package com.technotoil.ticket.util

import androidx.lifecycle.MutableLiveData

fun validMutable(value: MutableLiveData<String>): String {
    return if (value.value == null || value.value == "null") {
        ""
    } else {
        value.value.toString()
    }
}

fun setUpdatedDataMutable(value: MutableLiveData<String>, data: String) {
    if (value.value == null || value.value == "null") {
        value.value = data
    }
}

fun validString(value: String?): String {
    return if (value == null || value == "null") {
        ""
    } else {
        value
    }
}
