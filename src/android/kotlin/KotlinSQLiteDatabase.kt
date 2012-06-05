package android.kotlin

import android.database.sqlite.SQLiteDatabase
import android.database.Cursor
import java.util.List
import java.util.ArrayList
import java.util.Collections
import java.util.Collection
import java.util.LinkedList
import android.database.sqlite.SQLiteDatabase.CursorFactory

public fun SQLiteDatabase.transaction(action: SQLiteDatabase.() -> Unit): Unit {
    beginTransaction()
    try {
        action()
        setTransactionSuccessful()
    } finally {
        endTransaction()
    }
}

private fun toCollection<T>(cursor: Cursor?, action: Cursor.() -> T): Collection<out T> {
    val list = LinkedList<T>()
    if (cursor != null)
        try {
            if (cursor.moveToFirst())
                do {
                    list.add(cursor.action())
                } while (cursor.moveToNext())
        } finally {
            cursor.close()
        }
    return Collections.unmodifiableCollection(list).sure()
}

public inline fun SQLiteDatabase.query<T>(distinct: Boolean, table: String?, columns: Array<String?>? = null, selection: String? = null,
                               selectionArgs: Array<String?>? = null, groupBy: String? = null, having: String? = null, orderBy: String? = null,
                               limit: String? = null, action: Cursor.() -> T): Collection<out T> {
    return toCollection(query(distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit), action)
}

public inline fun SQLiteDatabase.queryWithFactory<T>(cursorFactory: CursorFactory?, distinct: Boolean, table: String?,
                                columns: Array<String?>? = null, selection: String? = null, selectionArgs: Array<String?>? = null,
                                groupBy: String? = null, having: String? = null, orderBy: String? = null, limit: String? = null,
                                action: Cursor.() -> T): Collection<out T> {
    return toCollection(queryWithFactory(cursorFactory, distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit), action)
}

public inline fun SQLiteDatabase.query<T>(table: String?, columns: Array<String?>?, selection: String?,
                                          selectionArgs: Array<String?>?, groupBy: String?, having: String?, orderBy: String?,
                                          limit: String?, action: Cursor.() -> T?): Collection<out T?> {
    return toCollection(query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit), action)
}

public inline fun SQLiteDatabase.query<T>(table: String?, columns: Array<String?>?, selection: String?,
                                          selectionArgs: Array<String?>?, groupBy: String?, having: String?, orderBy: String?,
                                          action: Cursor.() -> T): Collection<out T> {
    return toCollection(query(table, columns, selection, selectionArgs, groupBy, having, orderBy), action)
}

public inline fun SQLiteDatabase.rawQuery<T>(sql: String?, selectionArgs: Array<String?>?, action: Cursor.() -> T): Collection<out T> {
    return toCollection(rawQuery(sql, selectionArgs), action)
}

public inline fun SQLiteDatabase.rawQueryWithFactory<T>(cursorFactory: CursorFactory?, sql: String?, selectionArgs: Array<String?>?,
                                             editTable: String?, action: Cursor.() -> T): Collection<out T> {
    return toCollection(rawQueryWithFactory(cursorFactory, sql, selectionArgs, editTable), action)
}
