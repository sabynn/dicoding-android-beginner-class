package com.example.myrecommendation

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class KoreanDramaAdapter(private val listChar: ArrayList<KoreanDrama>) : RecyclerView.Adapter<KoreanDramaAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.activity_item_card, viewGroup,false )
        return ListViewHolder(view)
    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val context = holder.itemView.context
        val koreanDrama = listChar[position]
        Glide.with(holder.itemView.context)
            .load(koreanDrama.dramaPoster)
            .apply(RequestOptions())
            .into(holder.poster)
        holder.title.text = koreanDrama.title
        holder.info.text = koreanDrama.info
        holder.itemView.setOnClickListener {
            val detail = Intent(context, KdramaDetail::class.java)
            detail.putExtra(KdramaDetail.EXTRA_TITLE, koreanDrama.title)
            detail.putExtra(KdramaDetail.EXTRA_POSTER, koreanDrama.dramaPoster)
            detail.putExtra(KdramaDetail.EXTRA_INFO, koreanDrama.info)
            detail.putExtra(KdramaDetail.EXTRA_INFO_DETAIL, koreanDrama.infoDetail)
            detail.putExtra(KdramaDetail.EXTRA_SYNOPSIS, koreanDrama.synopsis)
            context.startActivity(detail)
        }
    }

    override fun getItemCount(): Int {
        return listChar.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.tv_drama_title)
        var poster: ImageView = itemView.findViewById(R.id.img_item_poster)
        var info: TextView = itemView.findViewById(R.id.tv_drama_info)
    }
}