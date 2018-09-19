package com.example.bawn.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bawn.noder_kotlin.Topic
import com.makeramen.roundedimageview.RoundedTransformationBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recent_topics_item.view.*

class RecentTopicsAdapter(val context: Context,
                          val dataArray: List<Topic>,
                          val itemClick: (Topic) -> Unit) : RecyclerView.Adapter<RecentTopicsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recent_topics_item, parent, false)
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

//            view.title.text = item.title
            view.date.text = item.last_reply_at
            Picasso.with(context)
                    .load(item.author.avatar_url)
                    .transform(transformation)
                    .into(view.avatar)

            view.setOnClickListener{itemClick(item)}

        }
    }
}