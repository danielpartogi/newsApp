package com.example.core.ui

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.core.R

fun Fragment.showWarningDialog(title: String = "", message: String = "") {
    activity?.let {
        val dialog = AlertDialog.Builder(it, R.style.AlertDialogDefault)
        dialog.setMessage(message)
            .setCancelable(false)
            .setPositiveButton(getString(R.string.lbl_okay)) { _, _ -> }
        if (title.isNotEmpty()) dialog.setTitle(title)
        dialog.show()
    }
}