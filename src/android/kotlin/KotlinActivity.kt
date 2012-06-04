package android.kotlin

import android.app.Activity
import android.view.View

public inline fun Activity.findView<T: View>(id: Int): T? = findViewById(id) as? T

public inline fun Activity.runOnUiThread(f: () -> Unit): Unit {
    runOnUiThread(runnable(f))
}
