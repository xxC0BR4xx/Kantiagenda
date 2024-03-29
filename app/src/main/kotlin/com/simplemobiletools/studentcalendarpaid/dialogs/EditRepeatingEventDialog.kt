package com.simplemobiletools.studentcalendarpaid.dialogs

import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.simplemobiletools.commons.extensions.hideKeyboard
import com.simplemobiletools.commons.extensions.setupDialogStuff
import kotlinx.android.synthetic.main.dialog_edit_repeating_event.view.*

class EditRepeatingEventDialog(val activity: com.simplemobiletools.studentcalendarpaid.activities.SimpleActivity, val callback: (allOccurrences: Boolean) -> Unit) {
    var dialog: AlertDialog

    init {
        val view = (activity.layoutInflater.inflate(com.simplemobiletools.studentcalendarpaid.R.layout.dialog_edit_repeating_event, null) as ViewGroup).apply {
            edit_repeating_event_one_only.setOnClickListener { sendResult(false) }
            edit_repeating_event_all_occurrences.setOnClickListener { sendResult(true) }
        }

        dialog = AlertDialog.Builder(activity)
                .create().apply {
                    activity.setupDialogStuff(view, this) {
                        hideKeyboard()
                    }
                }
    }

    private fun sendResult(allOccurrences: Boolean) {
        callback(allOccurrences)
        dialog.dismiss()
    }
}
