package com.vlad.android.kotlin
import android.util.Log

public trait KotlinLogTrait {
    fun e(tag: String, msg: String, e: Exception? = null) {
        if (e != null) {
            Log.e(tag, msg, e)
        } else {
            Log.e(tag, msg)
        }
    }

    fun i(tag: String, msg: String, e: Exception? = null) {
        if (e != null) {
            Log.i(tag, msg, e)
        } else {
            Log.i(tag, msg)
        }
    }

    fun v(tag: String, msg: String, e: Exception? = null) {
        if (e != null) {
            Log.v(tag, msg, e)
        } else {
            Log.v(tag, msg)
        }
    }

    fun d(tag: String, msg: String, e: Exception? = null) {
        if (e != null) {
          Log.d(tag, msg, e)
        } else {
          Log.d(tag, msg)
        }
    }

    fun w(tag: String, msg: String, e: Exception? = null) {
        if (e != null) {
            Log.w(tag, msg, e)
        } else {
            Log.w(tag, msg)
        }
    }
}