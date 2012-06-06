Kotlin for Android
=============

Helps not to write boilerplate code with instantiating abstract or interfaces instances.
The purpose of the library is to save time of writing code using Android SDK wrapping as much as possible
common functionality.

Warning
-------

This project is not relative to JetBrains company or their products. Use this project as is, no author nor anybody else
is responsible for any damage.

Linking to Android project
--------------------------

1. Create regular or use existing Android project in IDEA
2. Select `File` from menu and click on `Project Structure...`
3. Select `Libraries` section and add new Java library
4. Choose the source `src` folder of kotlinAndroidLib and click `Ok`
5. Choose category `sources` and click `Ok`
6. Select and name the library `kotlinAndroidLib`
7. Add new file to the library `^N` and choose classes.jar of kotlinAndroidLib
8. Add import to your kotlin files in the android project `import com.vlad.android.kotlin.*`

Usage
-----

Small example of usage most of the functions and also some examples like how to create Parcelable.
See [Sample Activity](https://github.com/vladlichonos/kotlinAndroidLib/blob/master/SampleActivity.kt)

* `findViewById` replacement for Activity and View:

        val myButton = findView<Button>(R.id.my_button)

* `setOnClickListener` for Views:

        myView?.setOnClickListener { /* code here */ }
        myView?.setOnClickListener { view -> /* code here with view: View? argument */ }
        val onClickListener = OnClickListener { view -> /* code here */ }

        myView?.setOnTouchListener { view, event -> false /* with view: View? and event: MotionEvent? */ }
        val onTouchListener = OnTouchListener { view, event -> false }

* `runOnUiThread` for Activities:

    It can be used without the library:

        runOnUiThread(runnable { /* action */})

    Library just remove runnable call and can be used as:

        runOnUiThread { /* action */ }

* Short definition of `BroadcastReceiver`:

    Library just wraps `onReceive` call:

        val myBroadcastReceiver = BroadcastReceiver { context, intent ->
            /* handle intent here */
        }

* `setPositiveButton` and `setNegativeButton` for AlertDialog.Builder:

        AlertDialog.Builder(this).setTitle("Hello")
            ?.setMessage("Want to say hello to world?")
            ?.setPositiveButton("Yes", { dialog, which -> /* hello */ })
            ?.setNegativeButton("No", { dialog, which -> /* no hello now */ })
            ?.create()

        val positiveButton = dialogOnClickListener { dialog, which -> }

* Short definition of `OnEditorActionListener`:

    Library just wraps `onEditorAction` call:

        val myEditorActionListener = OnEditorActionListener { v, actionId, event ->
            /* handle actionId and/or event */
            false
        }

        myEditText?.setOnEditorActionListener /* OnEditorActionListener */ { v, actionId, event ->
            false
        }

* `getSystemService` with or without casting for known services:

    Library allows call with casting for specific name of the service or call directly for known services:

        val inputMethodManager = getSystemServiceAs<InputMethodManager>(Context.INPUT_METHOD_SERVICE)
        val inputMethodManager = getInputMethodService()

* `AdapterView<out Adapter?>.setOnItemClickListener` and `AdapterView<out Adapter?>.setOnItemLongClickListener`:

        listView.setOnItemClickListener { parent, view, position, id -> }
        listView.setOnItemLongClickListener { parent, view, position, id -> false }

* Wrap calls without runnable() for `Handler`:

        val handler = Handler()
        handler.post { /* code here */ }
        handler.postDelayed(100) { /* code here */ }
        handler.postAtFrontOfQueue { /* code here */ }
        handler.postAtTime(System.currentTimeMillis() + 100) { /* code here */ }

* Wrap `SQLiteDatabase` functionality:

    * Wrap pattern: beginTransaction -> setTransactionSuccessful -> endTransaction with try and finally:

            sqliteDatabase.transaction {
                // call any method of SQLiteDatabase without . or ?.
                execSQL("ALTER TABLE table_1 RENAME TO table_2")
            }

    * Wrap pattern: cursor not null -> moveToFirst -> moveToNext in the do-while loop -> close with try and finally:

            // query call with same arguments + last argument is a body in the loop
            val collection /* of String */ = sqliteDatabase.query<String>("people", array("first_name"), null, null, null, null, null, null) {
                /* Cursor namespace */
                getString(getColumnIndexOrThrow("first_name"))
            }

        Support also queryWithFactory, rawQuery and rawQueryWithFactory.

    * Wrap ContentValues for insert and update:

            sqliteDatabase?.insert("table_name", null) {
                // ContentValues namespace
                put("column_text", "Hello")
                put("column_int", 12.toInt())
                put("column_float", 13.toFloat())
            }

            sqliteDatabase?.update("table_name", "ID = ?", array("3")) {
                // ContentValues namespace
                put("column_text", "Hello World")
            }

* `ExecutorService`:

        executorService.execute { /* code here */ }
        val future = executorService.submit<Any?> { /* code here and no result */ }
        val future = executorService.submit<String?> { /* code here */ "Result" }
        val future = executorService.submit<String?>("Result") { /* code here and result */ }

* Wrap `Intent`, now easy to create new `Intent` without defining new variable:

        sendBroadcast(Intent() { setAction(Intent.ACTION_DEFAULT) })
        startActivity(Intent(Intent.ACTION_VIEW) { setDataAndType(Uri.parse("http://example.com/audio.mp3"), "audio/mpeg") })

* Wrap `Bundle`, now easy to create new `Bundle` without defining new variable:

        Bundle { putString("result", "Some result!") }

