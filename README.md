Kotlin for Android
=============

    package com.example

    import android.app.Activity
    import android.os.Bundle
    import android.widget.Button
    import android.kotlin.*

    class HelloActivity : Activity() {

        val buttonHello = findView<Button>(R.id.button_hello)

        protected override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.main)

            buttonHello.v?.setOnClickListener {
                buttonHello.v?.setText("Hello World!")
            }

            AlertDialog.Builder(this).setTitle("Title")
                ?.setMessage("Hello World")
                ?.setPositiveButton("Yes", {dialog, which -> })
                ?.setNegativeButton("No", {dialog, which -> })
                ?.create()
                ?.show()
        }
    }
