package com.example.databindingexample

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

open class BaseViewModel: ViewModel() {
    val showLoader = MutableLiveData(View.GONE)
    val launchSnackBar = LiveEvent<String>()

}