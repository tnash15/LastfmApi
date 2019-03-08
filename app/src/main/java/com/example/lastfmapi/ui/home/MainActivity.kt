package com.example.lastfmapi.ui.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.lastfmapi.App
import com.example.lastfmapi.R
import com.example.lastfmapi.model.LastfmResponse
import com.example.lastfmapi.ui.home.di.DaggerHomeComponent
import com.example.lastfmapi.ui.home.di.HomeModule
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_activity.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HomeContract.View {

    private val lastFmAdapter = LastFmAdapter()

    @Inject
    lateinit var homePresenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         DaggerHomeComponent.builder()
            .appComponent((application as App).getAppComponent())
            .homeModule(HomeModule(this))
            .build()
            .inject(this)

        val layoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
        recyclerView.adapter = lastFmAdapter

        btnSearch.setOnClickListener {
            homePresenter.getInfo(etArtist.text.toString())
            homePresenter.getInfo(etAlbum.text.toString())
        }
    }

    override fun showLastFmInfo(results: List<LastfmResponse>) {
        lastFmAdapter.setData(results)
    }

    override fun showError(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

}
