package com.example.fitnessshop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fitnessshop.R
import com.example.fitnessshop.databinding.ItemNewsBinding
import com.example.newproject.model.Article

class NewsAdapter(val item: List<Article>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
    class ViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = item[position]


        holder.binding.tvTitle.text = items.title
        holder.binding.tvSearch.text = items.description

        Glide.with(holder.itemView.context).load(items.urlToImage).placeholder(R.drawable.defoult).into(holder.binding.ivSearch)
    }

    override fun getItemCount(): Int {
        return item.size

    }
}