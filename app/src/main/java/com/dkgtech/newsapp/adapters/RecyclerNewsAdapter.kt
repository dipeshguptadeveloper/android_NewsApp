package com.dkgtech.newsapp.adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dkgtech.newsapp.databinding.NewsRowBinding
import com.dkgtech.newsapp.models.ArticleModel
import com.dkgtech.newsapp.models.NewsModel

class RecyclerNewsAdapter(val context: Context, val listData: List<ArticleModel>) :
    RecyclerView.Adapter<RecyclerNewsAdapter.ViewHolder>() {
    class ViewHolder(val binding: NewsRowBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NewsRowBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            Glide.with(context).load(Uri.parse(listData[position].urlToImage)).into(imgSrc)
            txtTitle.text = listData[position].title
            txtDescription.text = listData[position].description
        }
    }
}