package com.example.lastfmapi.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.lastfmapi.R
import com.example.lastfmapi.model.LastfmResponse

class LastFmAdapter : RecyclerView.Adapter<LastFmAdapter.LastFmViewHolder>() {

    private val data = arrayListOf<LastfmResponse>()

    fun setData(result:List<LastfmResponse>) {
        data.clear()
        data.addAll(result)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastFmViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_activity,parent,false)
        return LastFmViewHolder(rootView)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(lastfmViewHolder: LastFmViewHolder, position: Int) {
        lastfmViewHolder.bind(data[position])
    }

    inner class LastFmViewHolder(val view: View):
            RecyclerView.ViewHolder(view) {
        fun bind(data: LastfmResponse) {
            val tvArtist = view.findViewById<TextView>(R.id.tvArtist)
            val tvAlbum = view.findViewById<TextView>(R.id.tvAlbum)
            tvArtist.text = data.artist
            tvAlbum.text = data.album
        }

    }

}