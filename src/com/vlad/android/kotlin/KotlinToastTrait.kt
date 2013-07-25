package com.vlad.android.kotlin

import android.widget.Toast
import android.content.Context

public trait KotlinToastTrait : Context {
  fun shortToast(resId : Int)  = Toast.makeText(this, resId, Toast.LENGTH_SHORT)!!.show()
  fun shortToast(str : String) = Toast.makeText(this, str, Toast.LENGTH_SHORT)!!.show()
  fun longToast(resId : Int)   = Toast.makeText(this, resId, Toast.LENGTH_LONG)!!.show()
  fun longToast(str : String)  = Toast.makeText(this, str, Toast.LENGTH_LONG)!!.show()
}