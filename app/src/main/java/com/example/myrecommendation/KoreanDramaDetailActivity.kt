package com.example.myrecommendation

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class KdramaDetail: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Korean Drama"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetTitle: TextView = findViewById(R.id.tv_set_title)
        val imgSetPoster: ImageView = findViewById(R.id.img_item_poster)
        val tvSetDetail: TextView = findViewById(R.id.tv_set_detail)
        val tvSynopsis: TextView = findViewById(R.id.tv_set_synopsis)

        val eTitle = intent.getStringExtra(EXTRA_TITLE)
        val ePoster = intent.getStringExtra(EXTRA_POSTER)
        val eInfoDetail = intent.getStringExtra(EXTRA_INFO_DETAIL)
        val eSynopsis = intent.getStringExtra(EXTRA_SYNOPSIS)

        tvSetTitle.text = eTitle
        Glide.with(this)
            .load(ePoster)
            .apply(RequestOptions())
            .into(imgSetPoster)
        tvSynopsis.text = eSynopsis
        tvSetDetail.text = eInfoDetail
    }

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_POSTER = "extra_poster"
        const val EXTRA_INFO = "extra_info"
        const val EXTRA_INFO_DETAIL = "extra_info_detail"
        const val EXTRA_SYNOPSIS = "extra_synopsis"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}