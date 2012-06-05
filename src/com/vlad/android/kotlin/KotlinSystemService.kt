package com.vlad.android.kotlin

import android.content.Context
import android.view.WindowManager
import android.view.LayoutInflater
import android.app.ActivityManager
import android.os.PowerManager
import android.app.AlarmManager
import android.app.NotificationManager
import android.app.KeyguardManager
import android.location.LocationManager
import android.app.SearchManager
import android.os.Vibrator
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.view.inputmethod.InputMethodManager
import android.app.UiModeManager
import android.app.DownloadManager

public inline fun Context.getSystemServiceAs<T>(name: String): T? = getSystemService(name) as? T

public inline fun Context.getWindowService(): WindowManager? = getSystemServiceAs(Context.WINDOW_SERVICE)
public inline fun Context.getLayoutInflaterService(): LayoutInflater? = getSystemServiceAs(Context.LAYOUT_INFLATER_SERVICE)
public inline fun Context.getActivityService(): ActivityManager? = getSystemServiceAs(Context.ACTIVITY_SERVICE)
public inline fun Context.getPowerService(): PowerManager? = getSystemServiceAs(Context.POWER_SERVICE)
public inline fun Context.getAlarmService(): AlarmManager? = getSystemServiceAs(Context.ALARM_SERVICE)
public inline fun Context.getNotificationService(): NotificationManager? = getSystemServiceAs(Context.NOTIFICATION_SERVICE)
public inline fun Context.getKeyguardService(): KeyguardManager? = getSystemServiceAs(Context.KEYGUARD_SERVICE)
public inline fun Context.getLocationService(): LocationManager? = getSystemServiceAs(Context.LOCATION_SERVICE)
public inline fun Context.getSearchService(): SearchManager? = getSystemServiceAs(Context.SEARCH_SERVICE)
public inline fun Context.getVibratorService(): Vibrator? = getSystemServiceAs(Context.VIBRATOR_SERVICE)
public inline fun Context.getConnectivityService(): ConnectivityManager? = getSystemServiceAs(Context.CONNECTIVITY_SERVICE)
public inline fun Context.getWifiService(): WifiManager? = getSystemServiceAs(Context.WIFI_SERVICE)
public inline fun Context.getInputMethodService(): InputMethodManager? = getSystemServiceAs(Context.INPUT_METHOD_SERVICE)
public inline fun Context.getUIModeService(): UiModeManager? = getSystemServiceAs(Context.UI_MODE_SERVICE)
public inline fun Context.getDownloadService(): DownloadManager? = getSystemServiceAs(Context.DOWNLOAD_SERVICE)
