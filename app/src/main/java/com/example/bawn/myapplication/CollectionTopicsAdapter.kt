package com.example.bawn.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bawn.noder_kotlin.Topic
import com.github.marlonlom.utilities.timeago.TimeAgo
import com.makeramen.roundedimageview.RoundedTransformationBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.collection_topics_item.view.*


class CollectionTopicsAdapter(val context: Context,
                          val dataArray: List<Topic>,
                          val itemClick: (Topic) -> Unit) : RecyclerView.Adapter<CollectionTopicsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.collection_topics_item, parent, false)
        return ViewHolder(context, view, itemClick)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(dataArray[position])
    }


    override fun getItemCount(): Int = dataArray.size

    class  ViewHolder(val context: Context,
                      val view: View,
                      val itemClick: (Topic) -> Unit) : RecyclerView.ViewHolder(view) {
        init {

        }

        fun bindItem(item: Topic) {
            val cornerRadius: Float = 26.0F
            val transformation = RoundedTransformationBuilder()
                    .cornerRadiusDp(cornerRadius)
                    .oval(true)
                    .build()

            view.title.text = item.title
            val date = item.create_at.toDate("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            view.date.text = TimeAgo.using(date.time)
            Picasso.with(context)
                    .load(item.author.avatar_url)
                    .transform(transformation)
                    .into(view.avatar)
            view.replyCount.text = item.reply_count.toString()
            view.viewCount.text = item.visit_count.toString()
            view.setOnClickListener{itemClick(item)}

        }
    }
}

