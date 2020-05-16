package com.example.databindingexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.example.databindingexample.databinding.FragmentHomeBinding

class HomeFragment: BaseFragment() {
    private val homeFragmentViewModel: HomeFragmentViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container, false ).apply {
            viewModel = homeFragmentViewModel
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSnackBarMessage()
        setupNavigateToGroupie()
    }

    private fun setupSnackBarMessage() {
        homeFragmentViewModel.launchSnackBar.observe(viewLifecycleOwner, Observer { message ->
            message?.let { text ->
                launchSnackBar(text)
            }
        })
    }

    private fun setupNavigateToGroupie() {
        homeFragmentViewModel.navigateToGroupie.observe(viewLifecycleOwner, Observer {
            NavHostFragment.findNavController(this).navigate(R.id.groupieFragment)
        })
    }
}