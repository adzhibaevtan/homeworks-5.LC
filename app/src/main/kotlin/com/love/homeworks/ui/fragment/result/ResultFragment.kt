package com.love.homeworks.ui.fragment.result

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.love.homeworks.R
import com.love.homeworks.databinding.FragmentResultBinding
import com.love.homeworks.model.LoveModel
import com.love.homeworks.preferences.Constants.KEY


class ResultFragment : Fragment(R.layout.fragment_result) {
    private val binding by viewBinding(FragmentResultBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultLove()
    }

    private fun resultLove() {
        var dataLove = arguments?.getSerializable(KEY)
        if (dataLove != null) {
            dataLove = dataLove as LoveModel
            with(binding) {
                firstNameTv.text = dataLove.firstName
                secondNameTv.text = dataLove.secondName
                percentageTv.text = dataLove.percentage
                resultTv.text = dataLove.result
            }
        }
    }


}