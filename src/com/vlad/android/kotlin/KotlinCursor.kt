package com.vlad.android.kotlin

import android.database.Cursor
import java.util.Collections
import java.util.LinkedList
import java.util.Collection

public inline fun <T> Cursor?.map(transform: Cursor.() -> T): Collection<T>  {
    return mapTo(LinkedList<T>(), transform)
}

public inline fun <T, C: Collection<T>> Cursor?.mapTo(result: C, transform: Cursor.() -> T): C {
    return if (this == null) result else {
        if (moveToFirst())
            do {
                result.add(transform())
            } while (moveToNext())
        result
    }
}

public inline fun <T> Cursor?.mapAndClose(create: Cursor.() -> T): Collection<T> {
    try {
        return map(create)
    } finally {
        this?.close()
    }
}
