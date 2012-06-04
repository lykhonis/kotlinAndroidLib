package com.example

import android.app.Activity
import android.os.Bundle
import android.kotlin.*
import android.widget.Button
import android.app.AlertDialog
import android.view.View.OnClickListener
import android.view.View
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import android.content.IntentFilter
import android.widget.TextView.OnEditorActionListener
import android.widget.TextView
import android.view.KeyEvent
import android.widget.EditText
import android.view.inputmethod.EditorInfo

class SampleActivity: Activity() {

    private val ACTION_HELLO = "com.example.intent.action.HELLO"

    private val DIALOG_EXAMPLE = 1

    public override fun onCreate(savedInstanceState: Bundle?) {
        super<Activity>.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val buttonHello = findView<Button>(R.id.button_hello)
        val edittext = findView<EditText>(R.id.edittext)

        buttonHello?.setOnClickListener { showDialog(DIALOG_EXAMPLE) }

        edittext?.setOnEditorActionListener { v, actionId, event ->
            when (actionId) {
                EditorInfo.IME_NULL -> {
                    getInputMethodService()?.hideSoftInputFromInputMethod(edittext?.getWindowToken(), 0)
                    Toast.makeText(this, "Enter", Toast.LENGTH_SHORT)?.show()
                    true
                }
                else -> false
            }
        }

        registerReceiver()
    }

    protected override fun onDestroy() {
        super<Activity>.onDestroy()

        unregisterReceiver(broadcastReceiver)
    }

    private fun registerReceiver() {
        val intentFilter = IntentFilter()
        intentFilter.addAction(ACTION_HELLO)
        registerReceiver(broadcastReceiver, intentFilter)
    }

    private val broadcastReceiver = BroadcastReceiver { context, intent ->
        Toast.makeText(context,
                when (intent?.getAction()) {
                    ACTION_HELLO -> "Hello world!"
                    else -> "Unknown action"
                }, Toast.LENGTH_LONG)?.show()
    }

    public override fun onCreateDialog(id: Int) = when (id) {
        DIALOG_EXAMPLE -> AlertDialog.Builder(this).setTitle("Title")
        ?.setMessage("Want to say hello to world?")
        ?.setPositiveButton("Yes", { dialog, which -> sendBroadcast(Intent(ACTION_HELLO)) })
        ?.setNegativeButton("No", { dialog, which -> })
        ?.create()
        else -> super.onCreateDialog(id)
    }
}
