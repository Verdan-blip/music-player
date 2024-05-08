package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.decorator

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.bagaviev.feed.impl.R

class TrackItemDecorator(
    private val context: Context
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.bottom = context.resources.getDimension(R.dimen.track_item_margin_between).toInt()
    }
}