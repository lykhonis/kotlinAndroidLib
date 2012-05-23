package android.kotlin

import android.app.Activity
import android.view.View

fun Activity.findView<T: View>(id: Int) = LazyView<T>(this, id)

fun Activity.runOnUiThread(f: () -> Unit) = runOnUiThread(runnable(f))
