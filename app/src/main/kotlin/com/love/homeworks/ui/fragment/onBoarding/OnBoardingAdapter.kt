package com.love.homeworks.ui.fragment.onBoarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.love.homeworks.R

import com.love.homeworks.databinding.FragmentOnBoardingBinding
import com.love.homeworks.databinding.ItemOnBoardBinding
import com.love.homeworks.model.OnBoard

class OnBoardingAdapter : Adapter<OnBoardingAdapter.OnBoardingViewHolder>(){
private val list = arrayListOf(
    OnBoard(R.raw.board1,"Love 1","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"),
    OnBoard(R.raw.board2,"Love 2","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"),
    OnBoard(R.raw.board3,"Love 3","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"),

)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = OnBoardingViewHolder (
        ItemOnBoardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: OnBoardingAdapter.OnBoardingViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() =list.size

    inner class OnBoardingViewHolder (private val binding: ItemOnBoardBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind (boarding: OnBoard) = with(binding) {
            boarding.image?.let {binding.vpImage.setAnimation(it)}
            vpTitle.text = boarding.title
            vpDesc.text = boarding.desc
        }

    }

}