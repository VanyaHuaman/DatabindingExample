package com.example.databindingexample

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment: Fragment() {
    private val baseViewModel : BaseViewModel by activityViewModels()

    fun launchSnackBar(message: String = "Generic SnackBar Message!") {
        val rootView = activity?.getRootView() //This is an extension function
        rootView?.let {view ->
            Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        baseViewModel.showLoader.value = View.GONE
    }
}