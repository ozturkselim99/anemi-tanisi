package com.selim.anemitanisi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.selim.anemitanisi.databinding.ResultItemRowBinding
import com.selim.anemitanisi.model.AnemiaResult

class ResultsAdapter : RecyclerView.Adapter<ResultsAdapter.MyViewHolder>() {

    var dataList = emptyList<AnemiaResult>()

    class MyViewHolder(private val binding: ResultItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(result: AnemiaResult) {
            binding.result = result
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ResultItemRowBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(dataList: List<AnemiaResult>) {
        this.dataList = dataList
    }

}