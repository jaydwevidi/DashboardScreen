package com.example.dashboardscreen

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aghajari.zoomhelper.ZoomHelper
import com.bumptech.glide.Glide

class FeedAdapter(val dataset : MutableList<tempPostModel> , val context : Context) : RecyclerView.Adapter<FeedAdapter.MyViewHolder>() {

    inner class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val personName : TextView = view.findViewById(R.id.postCreatorName)
        val caption : TextView = view.findViewById(R.id.caption)
        val personName2 : TextView = view.findViewById(R.id.profilename2)
        val personDP : ImageView = view.findViewById(R.id.uploaderDPImage)
        val postImage : ImageView = view.findViewById(R.id.postImage)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_item , parent , false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.personName.text = dataset[position].posterName
       holder.personName2.text = dataset[position].posterName
       holder.caption.text = dataset[position].content

        ZoomHelper.addZoomableView(holder.postImage)
        ZoomHelper.addZoomableView(holder.personDP)

        Glide.with(context)
            .load(dataset[position].posterDP)
            .fitCenter()
            .circleCrop()
            .into(holder.personDP)

        Glide.with(context)
            .load(dataset[position].postImage)
            .centerCrop()
            .into(holder.postImage)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}