package com.vlad.android.kotlin

import android.database.Cursor
import java.util.Collections
import java.util.LinkedList
import java.util.Collection

public inline fun <T> Cursor?.map(transform: Cursor.() -> T): Collection<T>  {
    return (if (this == null) Collections.emptyList<T>() else
        Collections.unmodifiableCollection(mapTo(LinkedList<T>(), transform))).sure()
}

public inline fun <T, C: Collection<in T>> Cursor?.mapTo(result: C, transform: Cursor.() -> T): C {
    if (this != null)
        if (this.moveToFirst())
            do {
                result.add(this.transform())
            } while (this.moveToNext())
    return result
}

public inline fun <T> Cursor?.mapAndClose(create: Cursor.() -> T): Collection<T> {
    try {
        return map(create)
    } finally {
        this?.close()
    }
}
