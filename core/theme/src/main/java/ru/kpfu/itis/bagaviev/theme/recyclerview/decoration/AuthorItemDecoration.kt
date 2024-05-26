package ru.kpfu.itis.bagaviev.theme.recyclerview.decoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.bagaviev.theme.R

class AuthorItemDecoration(
    private val context: Context
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.apply {
            left = context.resources.getDimension(
                R.dimen.author_item_margin_between
            ).toInt()
        }
    }
}