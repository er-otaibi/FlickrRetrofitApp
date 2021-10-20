package com.example.flickrbrowserappretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.pic_row.view.*

class PicAdapter ( private val myPic: List<Photo>):  RecyclerView.Adapter<PicAdapter.ItemViewHolder>(){
    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.pic_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var list1 = myPic[position]

        holder.itemView.apply {
            Glide.with(this)
                .load("${list1.url_t}")
                .into(imageView)
            textView.text = list1.title

//            imageView.setOnClickListener{
//                view.display("${list1.imageView}")
//            }
        }
    }
    override fun getItemCount() = myPic.size
}