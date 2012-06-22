package com.vlad.android.kotlin

import android.database.Cursor
import java.util.Collections
import java.util.LinkedList
import java.util.Collection

public inline fun <T> Cursor?.map(transform: Cursor.() -> T): Collection<T>  {
    return if (this == null) Collections.emptyList<T>().sure() else map(transform)
}

public inline fun <T, C: Collection<T>> Cursor?.mapTo(result: C, transform: Cursor.() -> T): C {
    return if (this == null) result else mapTo(result, transform)
}

public inline fun <T> Cursor?.mapAndClose(create: Cursor.() -> T): Collection<T> {
    try {
        return map(create)
    } finally {
        this?.close()
    }
}

public inline fun <T> Cursor.map(transform: Cursor.() -> T): Collection<T>  {
    return Collections.unmodifiableCollection(mapTo(LinkedList<T>(), transform)).sure()
}

public inline fun <T, C: Collection<T>> Cursor.mapTo(result: C, transform: Cursor.() -> T): C {
    if (moveToFirst())
        do {
            result.add(transform())
        } while (moveToNext())
    return result
}

public inline fun <T> Cursor.mapAndClose(create: Cursor.() -> T): Collection<T> {
    try {
        return map(create)
    } finally {
        close()
    }
}
