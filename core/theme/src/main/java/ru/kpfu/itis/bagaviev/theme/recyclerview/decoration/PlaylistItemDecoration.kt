package ru.kpfu.itis.bagaviev.theme.recyclerview.decoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.bagaviev.theme.R

class PlaylistItemDecoration(
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
                getDimension(R.dimen.playlist_item_margin_between).toInt(),
                0
            )
        }
    }
}