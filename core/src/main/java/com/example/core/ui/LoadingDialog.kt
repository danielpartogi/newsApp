package com.example.core.ui

import android.app.Dialog
import android.view.Window
import androidx.fragment.app.Fragment
import com.example.core.R


class LoadingDialog(fragment: Fragment) : Dialog(fragment.requireContext()) {

    fun showDialog() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(false)
        setContentView(R.layout.loading_dialog)
        show()
    }

    fun hideDialog() {
        dismiss()
    }

}