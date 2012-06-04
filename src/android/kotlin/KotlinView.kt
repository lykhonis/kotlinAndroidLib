package android.kotlin

import android.view.View
import android.app.Activity
import android.view.View.OnClickListener

public inline fun View.findView<T: View>(id: Int): T? = findViewById(id) as? T

public inline fun viewOnClickListener(action: (View?) -> Unit): OnClickListener {
    return object : OnClickListener {
        public override fun onClick(p0: View?) {
            action(p0)
        }
    }
}

public inline fun View.setOnClickListener(action: (View?) -> Unit): Unit {
    setOnClickListener(viewOnClickListener(action))
}
