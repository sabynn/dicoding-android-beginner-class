package com.example.myrecommendation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvKDrama: RecyclerView
    private var list: ArrayList<KoreanDrama> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar
        actionbar!!.title= "Korean Drama Recommendation"

        rvKDrama = findViewById(R.id.rv_kdrama)
        rvKDrama.setHasFixedSize(true)

        list.addAll(KoreanDramaData.listData)
        showRecyclerCard()
    }

    private fun showRecyclerCard() {
        rvKDrama.layoutManager = LinearLayoutManager(this)
        val listKdramaAdapter = KoreanDramaAdapter(list)
        rvKDrama.adapter = listKdramaAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val iAbout = Intent(this@MainActivity, About::class.java)
                startActivity(iAbout)
            }
        }
    }
}