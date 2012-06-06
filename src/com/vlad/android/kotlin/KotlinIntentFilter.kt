package com.vlad.android.kotlin

import android.content.IntentFilter

public inline fun IntentFilter(body: IntentFilter.() -> Unit): IntentFilter {
    val intentFilter = IntentFilter()
    intentFilter.body()
    return intentFilter
}
