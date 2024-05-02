package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.decorator

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.bagaviev.feed.impl.R
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.adapter.FeedAdapter

class FeedItemDecorator(
    private val context: Context
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        (parent.adapter as? FeedAdapter)?.apply {
            val position = parent.getChildAdapterPosition(view)
            outRect.setEmpty()
            with (context.resources) {
                if (isPlaylistsFeedPosition(position)) {
                    //outRect.bottom = getDimension(R.dimen.feed_fragment_playlists_margin_top).toInt()
                    outRect.left = getDimension(R.dimen.playlist_item_margin_outside).toInt()
                    outRect.right = getDimension(R.dimen.playlist_item_margin_outside).toInt()
                }
                if (isTracksFeedPosition(position)) {
                    outRect.bottom = getDimension(R.dimen.feed_fragment_tracks_margin_top).toInt()
                }
                if (isTrackFeedPosition(position)) {
                    outRect.bottom = getDimension(R.dimen.track_item_margin_between).toInt()
                    outRect.left = getDimension(R.dimen.track_item_margin_outside).toInt()
                    outRect.right = getDimension(R.dimen.track_item_margin_outside).toInt()
                }
                if (isSubtitleFeedPosition(position)) {
                    outRect.bottom = getDimension(R.dimen.feed_fragment_subtitle_margin_top).toInt()
                }
            }
        }
    }
}