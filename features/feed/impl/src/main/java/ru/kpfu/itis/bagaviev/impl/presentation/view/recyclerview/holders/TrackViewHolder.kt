package ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holders

import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.kpfu.itis.bagaviev.feed.domain.tracks.entites.responses.TrackResponseModel
import ru.kpfu.itis.bagaviev.impl.databinding.ItemTrackBinding

class TrackViewHolder(
    private val itemTrackBinding: ItemTrackBinding
) : RecyclerView.ViewHolder(itemTrackBinding.root) {

    fun bind(trackResponseModel: TrackResponseModel) {
        itemTrackBinding.apply {
            tvTrackTitle.text = trackResponseModel.title
            tvTrackUsers.text = trackResponseModel.users.joinToString(
                separator = " & ",
                transform = { userResponse -> userResponse.login }
            )
            ivTrackSmallIcon.load(trackResponseModel.smallCoverUri)
        }
    }
}