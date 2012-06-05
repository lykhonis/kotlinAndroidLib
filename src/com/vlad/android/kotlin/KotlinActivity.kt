package com.vlad.android.kotlin

import android.app.Activity
import android.view.View

public inline fun Activity.findView<T: View>(id: Int): T? = findViewById(id) as? T

public inline fun Activity.runOnUiThread(action: () -> Unit): Unit {
    runOnUiThread(runnable(action))
}
