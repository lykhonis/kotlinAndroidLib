Kotlin for Android
=============

    package com.example

    import android.app.Activity
    import android.os.Bundle
    import android.kotlin.*
    import android.widget.Button
    import android.app.AlertDialog
    import android.content.Context.*
    import android.content.SharedPreferences.Editor

    class HelloActivity : Activity() {

        private val DIALOG_EXAMPLE = 1

        public override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.main)

            val buttonHello = findView<Button>(R.id.button_hello)

            buttonHello?.setOnClickListener { showDialog(DIALOG_EXAMPLE) }
        }

        public override fun onCreateDialog(id: Int) = when (id) {
            DIALOG_EXAMPLE -> AlertDialog.Builder(this).setTitle("Title")
                ?.setMessage("Hello World")
                ?.setPositiveButton("Yes", {dialog, which -> })
                ?.setNegativeButton("No", {dialog, which -> })
                ?.create()
            else -> super.onCreateDialog(id)
        }
    }
