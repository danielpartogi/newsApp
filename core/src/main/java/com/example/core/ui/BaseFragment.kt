package com.example.core.ui

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.navigation.NavigationCommand

abstract class BaseFragment<T : BaseViewModel> : Fragment() {
    abstract val viewModel: BaseViewModel

    var loadingDialog: LoadingDialog? = null

    // UTILS METHODS ---

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeNavigation()
    }

    fun hideKeyboard() {
        val inputMethodManager =
            activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }

    fun showLoadingDialog(){
        loadingDialog = LoadingDialog(this)
        loadingDialog?.showDialog()
    }

    fun hideLoadingDialog(){
        if (loadingDialog == null) loadingDialog = LoadingDialog(this)
        else loadingDialog?.hide()
    }

    private fun observeNavigation() {

        viewModel.navigation.observe(viewLifecycleOwner, Observer {
            it?.getContentIfNotHandled()?.let { command ->
                when (command) {
                    is NavigationCommand.To -> findNavController().navigate(command.directions)
                    is NavigationCommand.Back -> findNavController().navigateUp()
                }
            }
        })
    }
}