package com.love.homeworks.ui.fragment.history

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.love.homeworks.R
import com.love.homeworks.databinding.FragmentHistoryBinding
import com.love.homeworks.ui.viewModel.HistoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment(R.layout.fragment_history) {
    private lateinit var adapter: HistoryAdapter
    private val viewModel: HistoryViewModel by viewModels()

    private val binding by viewBinding(FragmentHistoryBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appData()
        initAdapter()
    }

    private fun appData() {
        viewModel.getAlLiveLove()
        viewModel.liveLoveData.observe(viewLifecycleOwner) {
            adapter.loaData(it)
        }
    }

    private fun initAdapter() {
        adapter = HistoryAdapter()
        binding.recyclerHistory.adapter = adapter
    }


}