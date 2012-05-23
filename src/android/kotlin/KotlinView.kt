package android.kotlin

import android.view.View
import android.app.Activity
import android.view.View.OnClickListener as viewOnClickListener

fun View.setOnClickListener(f: (View?) -> Unit) = this.setOnClickListener(object : viewOnClickListener {
    public override fun onClick(p0: View?) {
        f(p0)
    }
})

class LazyView<T: View>(private val activity: Activity, val id: Int) {

    private var store: T? = null

    val v : T?
        get() {
            if (store == null)
                store = activity.findViewById(id) as? T
            return store;
        }
}