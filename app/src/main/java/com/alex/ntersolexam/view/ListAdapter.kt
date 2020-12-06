package com.alex.ntersolexam.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alex.ntersolexam.R
import com.alex.ntersolexam.model.Songs
import com.alex.ntersolexam.util.getProgressDrawable
import com.alex.ntersolexam.util.loadImage
import kotlinx.android.synthetic.main.detail_song.view.*


class ListAdapter(private val songList: ArrayList<Songs>):
    RecyclerView.Adapter<ListAdapter.SongViewHolder>(){

    fun updateList(newHumansList: List<Songs>) {
        songList.clear()
        songList.addAll(newHumansList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.detail_song, parent, false)
        return SongViewHolder(view)
    }

    override fun getItemCount() = songList.size

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.view.textSongTitle.text = songList[position].name
        holder.view.textArtist.text = songList[position].userDisplayName
        holder.view.imageViewName.loadImage(songList[position].profileImageUrl, getProgressDrawable(holder.view.context))
    }

    class SongViewHolder(var view: View): RecyclerView.ViewHolder(view)
}