Kotlin for Android
=============

    package com.example

    import android.app.Activity
    import android.os.Bundle
    import android.content.Context
    import android.widget.Button
    import android.kotlin.*

    class HelloActivity : Activity() {

        val button = findView<Button>(R.id.button_hello)

        protected override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.main)

            button.v?.setOnClickListener { view -> (view as? Button)?.setText("You clicked on me") }
        }
    }
