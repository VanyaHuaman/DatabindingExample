package com.example.databindingexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.databindingexample.databinding.FragmentGroupieBinding

class GroupieFragment: BaseFragment() {
    private val groupieFragmentViewModel: GroupieFragmentViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<FragmentGroupieBinding>(inflater, R.layout.fragment_groupie, container, false ).apply {
            viewModel = groupieFragmentViewModel
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

}