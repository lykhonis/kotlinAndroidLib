package com.vlad.android.kotlin

import android.os.Parcelable
import android.os.Parcel
import java.util.Arrays
import java.util.ArrayList
import android.os.Bundle

//public class MyParcelable(val number: Int, val text: String?) : Parcelable {
//
//    public override fun writeToParcel(p0: Parcel?, p1: Int) {
//        if (p0 != null) {
//            p0.writeInt(number)
//            p0.writeString(text)
//        }
//    }
//
//    public override fun describeContents(): Int = 0
//
//    class object {
//
//        fun create(parcel: Parcel?) = if (parcel == null) null else
//            MyParcelable(parcel.readInt(), parcel.readString())
//
//        val CREATOR = object : Parcelable.Creator<MyParcelable> {
//
//            public override fun createFromParcel(p0: Parcel?): MyParcelable? = create(p0)
//
//            public override fun newArray(p0: Int): Array<MyParcelable?>? = array<MyParcelable?>()
//        }
//    }
//}
