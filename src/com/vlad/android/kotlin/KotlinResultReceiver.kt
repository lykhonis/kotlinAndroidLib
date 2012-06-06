package com.vlad.android.kotlin

import android.os.ResultReceiver
import android.os.Handler
import android.os.Bundle

public inline fun ResultReceiver(receive: (Int, Bundle?) -> Unit): ResultReceiver = ResultReceiver(Handler(), receive)

public inline fun ResultReceiver(handler: Handler?, receive: (Int, Bundle?) -> Unit): ResultReceiver {
    return object : ResultReceiver(handler) {
        protected override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
            receive(resultCode, resultData)
        }
    }
}
