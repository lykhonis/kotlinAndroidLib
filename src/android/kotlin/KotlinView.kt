package android.kotlin

import android.view.View
import android.app.Activity
import android.view.View.OnClickListener

fun viewOnClickListener(action: (View?) -> Unit) = object : OnClickListener {
    public override fun onClick(p0: View?) {
        action(p0)
    }
}

fun View.setOnClickListener(action: (View?) -> Unit) = setOnClickListener(viewOnClickListener(action))

class LazyView<T: View>(private val activity: Activity, val id: Int) {

    private var store: T? = null

    val v : T?
        get() {
            if (store == null)
                store = activity.findViewById(id) as? T
            return store;
        }
}