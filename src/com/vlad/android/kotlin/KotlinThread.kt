package com.vlad.android.kotlin

public inline fun async(action: () -> Unit): Unit = Thread(runnable(action)).start()
