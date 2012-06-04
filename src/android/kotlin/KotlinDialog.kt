package android.kotlin

import android.app.Dialog
import android.view.View
import android.content.DialogInterface.OnClickListener
import android.content.DialogInterface
import android.app.AlertDialog
import android.app.AlertDialog.Builder

public inline fun dialogOnClickListener(action: (dialog: DialogInterface?, which: Int) -> Unit): OnClickListener {
    return object : OnClickListener {
        public override fun onClick(p0: DialogInterface?, p1: Int) = action(p0, p1)
    }
}

public inline fun Builder.setPositiveButton(textId: Int, action: (dialog: DialogInterface?, which: Int) -> Unit): Builder? =
    setPositiveButton(textId, dialogOnClickListener(action))

public inline fun Builder.setPositiveButton(text: CharSequence, action: (dialog: DialogInterface?, which: Int) -> Unit): Builder? =
    setPositiveButton(text, dialogOnClickListener(action))

public inline fun Builder.setNegativeButton(textId: Int, action: (dialog: DialogInterface?, which: Int) -> Unit): Builder? =
    setNegativeButton(textId, dialogOnClickListener(action))

public inline fun Builder.setNegativeButton(text: CharSequence, action: (dialog: DialogInterface?, which: Int) -> Unit): Builder? =
    setNegativeButton(text, dialogOnClickListener(action))
