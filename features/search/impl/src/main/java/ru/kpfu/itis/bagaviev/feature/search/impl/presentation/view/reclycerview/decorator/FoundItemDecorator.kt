package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.decorator

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.bagaviev.feature.search.impl.R
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.adapter.FoundAdapter

class FoundItemDecorator(
    private val context: Context
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        (parent.adapter as? FoundAdapter)?.apply {
            val position = parent.getChildAdapterPosition(view)
            outRect.setEmpty()
            with (context.resources) {
                if (isPlaylistsFoundPosition(position)) {
                    outRect.top = getDimension(R.dimen.playlist_item_margin_top).toInt()
                    outRect.left = getDimension(R.dimen.playlist_item_margin_outside).toInt()
                    outRect.right = getDimension(R.dimen.playlist_item_margin_outside).toInt()
                }
                if (isTracksFoundPosition(position)) {
                    outRect.bottom = getDimension(R.dimen.search_fragment_tracks_margin_top).toInt()
                }
                if (isTrackFoundPosition(position)) {
                    outRect.bottom = getDimension(R.dimen.track_item_margin_between).toInt()
                    outRect.left = getDimension(R.dimen.track_item_margin_outside).toInt()
                    outRect.right = getDimension(R.dimen.track_item_margin_outside).toInt()
                }
                if (isSubtitleFoundPosition(position)) {
                    outRect.bottom = getDimension(R.dimen.search_fragment_subtitle_margin_top).toInt()
                }
            }
        }
    }
}