package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.decorator

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.bagaviev.feed.impl.R
import ru.kpfu.itis.bagaviev.theme.recyclerview.adapter.PlayableAdapter
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.PlaylistGroupRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.SubtitleRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackRvModel

class FeedItemDecoration(
    private val context: Context
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        val currentPlayable = (parent.adapter as PlayableAdapter).getPlayableList()[position]

        context.resources.apply {
            outRect.apply {
                when (currentPlayable) {
                    is SubtitleRvModel -> {
                        bottom = getDimension(R.dimen.feed_fragment_subtitle_margin_top).toInt()
                    }
                    is TrackRvModel -> {
                        bottom = getDimension(R.dimen.track_item_margin_between).toInt()
                    }
                    is PlaylistGroupRvModel -> {
                        bottom = getDimension(R.dimen.playlist_item_margin_between).toInt()
                    }
                }
            }
        }
    }
}