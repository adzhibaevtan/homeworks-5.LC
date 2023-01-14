package com.love.homeworks.ui.fragment.onBoarding

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import by.kirich1409.viewbindingdelegate.viewBinding
import com.love.homeworks.R
import com.love.homeworks.data.local.sharedPref.PreferencesManager
import com.love.homeworks.databinding.FragmentOnBoardingBinding
import com.love.homeworks.ui.viewModel.OnBoardingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingFragment : Fragment(R.layout.fragment_on_boarding) {
    private val viewModel: OnBoardingViewModel by viewModels()
    private val binding by viewBinding(FragmentOnBoardingBinding::bind)
    private val onBoardAdapter = OnBoardingAdapter()
    private val preferencesManager by lazy {
        PreferencesManager(
            requireContext().getSharedPreferences("preferences", Context.MODE_PRIVATE)
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.adapter = onBoardAdapter
        navigateToCalculateIfUserHasSeenOnboard()
        setupListeners()
        initObserve()

        viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                start.isVisible = position == onBoardAdapter.itemCount - 1
                skip.isVisible = position != onBoardAdapter.itemCount - 1
            }
        })
        dotsIndicator.attachTo(viewPager)
    }

    private fun setupListeners() {
        listOf<View>(binding.skip, binding.start).forEach {
            it.setOnClickListener {
                navigateToCalculate()
            }
        }
    }

    private fun navigateToCalculateIfUserHasSeenOnboard() {
        if (preferencesManager.hasUserSeenOnBoarding) {
            findNavController().navigate(R.id.action_onBoardingFragment_to_calculateFragment)
        }
    }

    private fun navigateToCalculate() {
        preferencesManager.hasUserSeenOnBoarding = true
        findNavController().navigate(R.id.action_onBoardingFragment_to_calculateFragment)
    }

    private fun initObserve() {
        viewModel.hasUserSeenOnBoarding()
    }


}
