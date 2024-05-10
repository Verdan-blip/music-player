package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.decorator

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.bagaviev.feature.search.impl.R

class PlaylistItemDecorator(
    private val context: Context
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        with (context.resources) {
            outRect.set(
                0,
                0,
                getDimension(R.dimen.search_fragment_margin_between_playlists).toInt(),
                0
            )
        }
    }
}