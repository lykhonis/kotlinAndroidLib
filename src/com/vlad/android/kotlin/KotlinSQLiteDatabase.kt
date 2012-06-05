package com.vlad.android.kotlin

import android.database.sqlite.SQLiteDatabase
import android.database.Cursor
import java.util.List
import java.util.ArrayList
import java.util.Collections
import java.util.Collection
import java.util.LinkedList
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.content.ContentValues

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

public inline fun SQLiteDatabase.insert(table: String?, nullColumnHack: String?, action: ContentValues.() -> Unit): Long {
    val values = ContentValues()
    values.action()
    return insert(table, nullColumnHack, values)
}

public inline fun SQLiteDatabase.insertOrThrow(table: String?, nullColumnHack: String?, action: ContentValues.() -> Unit): Long {
    val values = ContentValues()
    values.action()
    return insertOrThrow(table, nullColumnHack, values)
}

public inline fun SQLiteDatabase.insertWithOnConflict(table: String?, nullColumnHack: String?, conflictAlgorithm: Int, action: ContentValues.() -> Unit): Long {
    val values = ContentValues()
    values.action()
    return insertWithOnConflict(table, nullColumnHack, values, conflictAlgorithm)
}

public inline fun SQLiteDatabase.update(table: String?, whereClause: String?, whereArgs: Array<String?>?, action: ContentValues.() -> Unit): Int {
    val values = ContentValues()
    values.action()
    return update(table, values, whereClause, whereArgs)
}

public inline fun SQLiteDatabase.updateWithOnConflict(table: String?, whereClause: String?, whereArgs: Array<String?>?, conflictAlgorithm: Int, action: ContentValues.() -> Unit): Int {
    val values = ContentValues()
    values.action()
    return updateWithOnConflict(table, values, whereClause, whereArgs, conflictAlgorithm)
}
