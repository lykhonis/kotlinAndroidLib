package android.kotlin

import android.app.Dialog
import android.view.View
import android.content.DialogInterface.OnClickListener
import android.content.DialogInterface
import android.app.AlertDialog
import android.app.AlertDialog.Builder

fun dialogOnClickListener(action: (dialog: DialogInterface?, which: Int) -> Unit): OnClickListener =
    object : OnClickListener {
        public override fun onClick(p0: DialogInterface?, p1: Int) {
            action(p0, p1)
        }
    }

fun Builder.setPositiveButton(textId: Int, action: (dialog: DialogInterface?, which: Int) -> Unit) =
    setPositiveButton(textId, dialogOnClickListener(action))

fun Builder.setPositiveButton(text: CharSequence, action: (dialog: DialogInterface?, which: Int) -> Unit) =
    setPositiveButton(text, dialogOnClickListener(action))

fun Builder.setNegativeButton(textId: Int, action: (dialog: DialogInterface?, which: Int) -> Unit) =
    setNegativeButton(textId, dialogOnClickListener(action))

fun Builder.setNegativeButton(text: CharSequence, action: (dialog: DialogInterface?, which: Int) -> Unit) =
    setNegativeButton(text, dialogOnClickListener(action))