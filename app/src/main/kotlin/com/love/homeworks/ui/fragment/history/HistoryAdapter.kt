package com.love.homeworks.ui.fragment.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.love.homeworks.databinding.ItemHistoryBinding
import com.love.homeworks.model.LoveModel

class HistoryAdapter : Adapter<HistoryAdapter.HistoryViewHolder>() {

    val data = arrayListOf<LoveModel>()

    fun loaData(newData: List<LoveModel>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HistoryViewHolder(
        ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        ViewHolder(binding.root) {
        fun onBind(item: LoveModel) {
            with(binding) {
                fnHistory.text = item.firstName
                snHistory.text = item.secondName
                perHistory.text = item.percentage
            }
        }

    }
}
