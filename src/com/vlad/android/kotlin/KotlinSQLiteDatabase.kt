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

private fun toCollection<T>(cursor: Cursor?, create: Cursor.() -> T): Collection<out T> {
    val list = LinkedList<T>()
    if (cursor != null)
        try {
            if (cursor.moveToFirst())
                do {
                    list.add(cursor.create())
                } while (cursor.moveToNext())
        } finally {
            cursor.close()
        }
    return Collections.unmodifiableCollection(list).sure()
}

public inline fun SQLiteDatabase.query<T>(distinct: Boolean, table: String?, columns: Array<String?>? = null, selection: String? = null,
                               selectionArgs: Array<String?>? = null, groupBy: String? = null, having: String? = null, orderBy: String? = null,
                               limit: String? = null, create: Cursor.() -> T): Collection<out T> {
    return toCollection(query(distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit), create)
}

public inline fun SQLiteDatabase.queryWithFactory<T>(cursorFactory: CursorFactory?, distinct: Boolean, table: String?,
                                columns: Array<String?>? = null, selection: String? = null, selectionArgs: Array<String?>? = null,
                                groupBy: String? = null, having: String? = null, orderBy: String? = null, limit: String? = null,
                                create: Cursor.() -> T): Collection<out T> {
    return toCollection(queryWithFactory(cursorFactory, distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit), create)
}

public inline fun SQLiteDatabase.query<T>(table: String?, columns: Array<String?>?, selection: String?,
                                          selectionArgs: Array<String?>?, groupBy: String?, having: String?, orderBy: String?,
                                          limit: String?, create: Cursor.() -> T?): Collection<out T?> {
    return toCollection(query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit), create)
}

public inline fun SQLiteDatabase.query<T>(table: String?, columns: Array<String?>?, selection: String?,
                                          selectionArgs: Array<String?>?, groupBy: String?, having: String?, orderBy: String?,
                                          create: Cursor.() -> T): Collection<out T> {
    return toCollection(query(table, columns, selection, selectionArgs, groupBy, having, orderBy), create)
}

public inline fun SQLiteDatabase.rawQuery<T>(sql: String?, selectionArgs: Array<String?>?, create: Cursor.() -> T): Collection<out T> {
    return toCollection(rawQuery(sql, selectionArgs), create)
}

public inline fun SQLiteDatabase.rawQueryWithFactory<T>(cursorFactory: CursorFactory?, sql: String?, selectionArgs: Array<String?>?,
                                             editTable: String?, create: Cursor.() -> T): Collection<out T> {
    return toCollection(rawQueryWithFactory(cursorFactory, sql, selectionArgs, editTable), create)
}

public inline fun SQLiteDatabase.insert(table: String?, nullColumnHack: String?, create: ContentValues.() -> Unit): Long {
    val values = ContentValues()
    values.create()
    return insert(table, nullColumnHack, values)
}

public inline fun SQLiteDatabase.insertOrThrow(table: String?, nullColumnHack: String?, create: ContentValues.() -> Unit): Long {
    val values = ContentValues()
    values.create()
    return insertOrThrow(table, nullColumnHack, values)
}

public inline fun SQLiteDatabase.insertWithOnConflict(table: String?, nullColumnHack: String?, conflictAlgorithm: Int, create: ContentValues.() -> Unit): Long {
    val values = ContentValues()
    values.create()
    return insertWithOnConflict(table, nullColumnHack, values, conflictAlgorithm)
}

public inline fun SQLiteDatabase.update(table: String?, whereClause: String?, whereArgs: Array<String?>?, create: ContentValues.() -> Unit): Int {
    val values = ContentValues()
    values.create()
    return update(table, values, whereClause, whereArgs)
}

public inline fun SQLiteDatabase.updateWithOnConflict(table: String?, whereClause: String?, whereArgs: Array<String?>?, conflictAlgorithm: Int, create: ContentValues.() -> Unit): Int {
    val values = ContentValues()
    values.create()
    return updateWithOnConflict(table, values, whereClause, whereArgs, conflictAlgorithm)
}
