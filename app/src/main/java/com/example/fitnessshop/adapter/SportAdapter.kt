package com.example.fitnessshop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fitnessshop.R
import com.example.fitnessshop.databinding.ItemSportsBinding
import com.example.fitnessshop.model.Model

class SportAdapter(val item:List<Model>):RecyclerView.Adapter<SportAdapter.ViewHolder>() {
    class ViewHolder(val binding:ItemSportsBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSportsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val items = item[position]
        holder.binding.tvSport.text = items.title
        Glide.with(holder.itemView.context).load(items.urlToImage).placeholder(R.drawable.defoult).into(holder.binding.ivSport)
    }

    override fun getItemCount(): Int {
        return item.size
    }
}