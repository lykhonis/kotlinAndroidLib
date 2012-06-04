package android.kotlin

import android.view.View
import android.app.Activity
import android.view.View.OnClickListener

fun View.findView<T: View>(id: Int) = findViewById(id) as? T

fun viewOnClickListener(action: (View?) -> Unit) = object : OnClickListener {
    public override fun onClick(p0: View?) {
        action(p0)
    }
}

fun View.setOnClickListener(action: (View?) -> Unit) = setOnClickListener(viewOnClickListener(action))