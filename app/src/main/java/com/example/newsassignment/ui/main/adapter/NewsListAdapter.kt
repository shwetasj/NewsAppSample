package com.example.newsassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsassignment.R
import com.example.newsassignment.model.NewsData


class NewsListAdapter(var context: Context, var newsList: ArrayList<NewsData>) :
    RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    lateinit var onItemClick: ((String) -> Unit?)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view: View =
            LayoutInflater.from(context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsList.get(position))
    }

    override fun getItemCount(): Int = newsList.size

    class ViewHolder(
        val newsItemView: View,
        val onItemClick: (String) -> Unit?
    ) : RecyclerView.ViewHolder(newsItemView) {
        var source: AppCompatTextView
        var iv_news: AppCompatImageView
        var tv_head: AppCompatTextView
        var tv_author: AppCompatTextView
        var tv_date: AppCompatTextView

        init {
            source = newsItemView.findViewById(R.id.tv_source)
            iv_news = newsItemView.findViewById(R.id.iv_news)
            tv_date = newsItemView.findViewById(R.id.tv_date)
            tv_author = newsItemView.findViewById(R.id.tv_author)
            tv_head = newsItemView.findViewById(R.id.tv_head)
        }

        fun bind(data: NewsData) {
            source.text = data.source.name
            tv_date.text = String.format(data.published_at).replace('T', ' ').replace('Z', ' ')
            tv_author.text = data.author
            tv_head.text = data.title
            loadImageCache(iv_news, data.url_to_image, R.drawable.bg_transparent)
            newsItemView.setOnClickListener { onItemClick(data.url) }
        }
    }
}
