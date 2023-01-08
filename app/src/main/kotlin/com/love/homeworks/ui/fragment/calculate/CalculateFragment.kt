package com.love.homeworks.ui.fragment.calculate

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.love.homeworks.R
import com.love.homeworks.databinding.FragmentCalculateBinding
import com.love.homeworks.model.LoveModel
import com.love.homeworks.preferences.Constants.KEY
import com.love.homeworks.remote.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CalculateFragment : Fragment(R.layout.fragment_calculate) {
    private val binding by viewBinding(FragmentCalculateBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
        afterTextChanged()
        animation()
    }

    private fun initClicker() {
        with(binding) {
            calculateBtn.setOnClickListener {
                RetrofitService().getLoveApi().getResultLove(
                    firstName = etFirstName.text.toString(),
                    secondName = etSecondName.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        val dataLove = response.body()
                        if (binding.etFirstName.text.toString()
                                .isNotEmpty() || binding.etSecondName.text.toString().isNotEmpty()
                        ) {
                            findNavController().navigate(
                                R.id.resultFragment,
                                bundleOf(KEY to dataLove)
                            )
                        }

                        Log.e("check", "onResponse: ${response.body()?.percentage} ")
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("check", "onFailure: ${t.message}")
                    }
                })
            }
        }
    }

    private fun afterTextChanged() {

        binding.etFirstName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.etFirstName.text.toString()
                        .isNotEmpty() && binding.etSecondName.text.toString().isNotEmpty()
                ) {
                    binding.calculateBtn.setBackgroundDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.gradient
                        )
                    )
                } else {
                    binding.calculateBtn.setBackgroundDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.dark_gradient
                        )
                    )
                }
            }


            override fun afterTextChanged(editable: Editable?) {
            }
        })

        binding.etSecondName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.etFirstName.text.toString()
                        .isNotEmpty() && binding.etSecondName.text.toString().isNotEmpty()
                ) {
                    binding.calculateBtn.setBackgroundDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.gradient
                        )
                    )
                } else {
                    binding.calculateBtn.setBackgroundDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.dark_gradient
                        )
                    )
                }
            }

            override fun afterTextChanged(editable: Editable?) {
            }
        })
    }

    private fun animation() {
        Glide.with(requireContext()).asGif()
            .load("https://i.giphy.com/media/xT0BKwnNei3RLivHlS/giphy.gif").into(binding.image1)
    }
}
