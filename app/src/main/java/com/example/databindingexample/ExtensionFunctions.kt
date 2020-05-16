package com.example.databindingexample

import android.app.Activity
import android.view.View

fun Activity.getRootView(): View {
    return findViewById(android.R.id.content)
}
