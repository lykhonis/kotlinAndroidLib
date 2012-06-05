package com.vlad.android.kotlin

import android.os.Handler

public inline fun Handler.post(action: () -> Unit): Boolean = post(runnable(action))
public inline fun Handler.postAtFrontOfQueue(action: () -> Unit): Boolean = postAtFrontOfQueue(runnable(action))
public inline fun Handler.postAtTime(uptimeMillis: Long, action: () -> Unit): Boolean = postAtTime(runnable(action), uptimeMillis)
public inline fun Handler.postDelayed(delayMillis: Long, action: () -> Unit): Boolean = postDelayed(runnable(action), delayMillis)
