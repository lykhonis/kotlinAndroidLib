package com.example

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.vlad.android.kotlin.*

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
                    getInputMethodService()?.hideSoftInputFromWindow(edittext?.getWindowToken(), 0)
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

/** Working example of how to create Parcelable */
class MyParcelable(val number: Int, val text: String?) : Parcelable {

    public override fun writeToParcel(p0: Parcel?, p1: Int) {
        if (p0 != null) {
            p0.writeInt(number)
            p0.writeString(text)
        }
    }

    public override fun describeContents(): Int = 0

    class object {

        private fun create(parcel: Parcel) = MyParcelable(parcel.readInt(), parcel.readString())

        val CREATOR = object : Parcelable.Creator<MyParcelable> {

            public override fun createFromParcel(p0: Parcel?): MyParcelable? = create(p0.sure())

            public override fun newArray(p0: Int): Array<MyParcelable?>? = array<MyParcelable?>()
        }
    }
}
