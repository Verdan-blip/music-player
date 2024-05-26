package ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.decorator

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.bagaviev.feature.upload.R

class FoundUsersItemDecorator(
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
            context.resources.apply {
                right = getDimension(R.dimen.upload_fragment_search_users_margin_between).toInt()
            }
        }
    }
}