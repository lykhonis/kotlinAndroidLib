package android.kotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

public inline fun BroadcastReceiver(action: (Context?, Intent?) -> Unit): BroadcastReceiver {
    return object : BroadcastReceiver() {
        public override fun onReceive(p0: Context?, p1: Intent?) {
            action(p0, p1)
        }
    }
}
