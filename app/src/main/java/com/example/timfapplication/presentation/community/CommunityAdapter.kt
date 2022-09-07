package com.example.timfapplication.presentation.community

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.timfapplication.R
import com.example.timfapplication.domain.entity.community.ResponseModel

class CommunityAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val ITEM = 1
        const val LOADING = 0
    }

    private var items = mutableListOf<ResponseModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(responseModel: ResponseModel) {
        this.items.clear()
        this.items.add(responseModel)
        notifyDataSetChanged()
    }

    inner class CommunityViewHolder(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        fun bind(repo: ResponseModel) {
            repo.data?.forEach {
                itemView.findViewById<TextView>(R.id.tv_title).text = it?.boardSj
                itemView.findViewById<TextView>(R.id.tv_description).text = it?.boardCn
            }
        }
    }

    inner class LoadingViewHolder(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        val progressBar = itemView.findViewById<ProgressBar>(R.id.progressBar)!!
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] != null) {
            ITEM
        } else {
            LOADING
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ITEM) {
            val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_community, parent, false)
            CommunityViewHolder(layoutInflater)
        } else {
            val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_loading, parent, false)
            LoadingViewHolder(layoutInflater)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CommunityViewHolder) {
            holder.bind(items[position]!!)
        } else {

        }
    }

    override fun getItemCount(): Int = items.size
}