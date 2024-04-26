package ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.bagaviev.feed.domain.tracks.entites.responses.TrackResponseModel
import ru.kpfu.itis.bagaviev.impl.databinding.ItemTrackBinding
import ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holders.TrackViewHolder

class TracksAdapter(
    private var context: Context
) : RecyclerView.Adapter<TrackViewHolder>() {

    private var trackResponseList = listOf<TrackResponseModel>()

    fun setData(newTrackResponseList: List<TrackResponseModel>) {
        trackResponseList = newTrackResponseList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder =
        TrackViewHolder(ItemTrackBinding.inflate(
            LayoutInflater.from(context), parent, false)
        )

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(trackResponseList[position])
    }

    override fun getItemCount(): Int = trackResponseList.size
}