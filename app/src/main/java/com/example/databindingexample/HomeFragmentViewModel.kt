package com.example.databindingexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.hadilq.liveevent.LiveEvent

class HomeFragmentViewModel: BaseViewModel() {

    private val _total = MutableLiveData(0)
    val totalText : LiveData<String> = _total.map { it.toString() }

    val navigateToGroupie = LiveEvent<Boolean>()

    fun navigateToGroupieFragment() {
        navigateToGroupie.value = true
    }

    fun plusButtonOnClick() {
        _total.value = _total.value?.plus(1)
    }

    fun negativeButtonOnClick() {
        _total.value?.let {
            if (it > 0) {
                _total.value = _total.value?.minus(1)
            }
        }
    }

    fun messageButtonOnClick() {
        launchSnackBar.value = "You launched a SnackBar with a Live Event"
    }
}