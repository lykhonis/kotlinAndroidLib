package com.vlad.android.kotlin

import android.os.Parcelable
import android.os.Parcel
import java.util.ArrayList

public inline fun CreateParcelable<T: Parcelable>(create: (Parcel) -> T?): Parcelable.Creator<T> {
    return object : Parcelable.Creator<T> {
        public override fun createFromParcel(p0: Parcel?): T? = if (p0 != null) create(p0) else null
        public override fun newArray(p0: Int): Array<T>? = arrayOfNulls<T?>(p0) as Array<T>?
    }
}
