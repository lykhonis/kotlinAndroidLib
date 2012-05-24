package android.kotlin

import android.app.Activity
import android.view.View

fun Activity.findView<T: View>(id: Int) = findViewById(id) as? T

fun Activity.runOnUiThread(f: () -> Unit) = runOnUiThread(runnable(f))
