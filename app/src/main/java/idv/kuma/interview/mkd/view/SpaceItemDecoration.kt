package idv.kuma.interview.mkd.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import idv.kuma.interview.mkd.utils.px
import idv.kuma.interview.mkd.utils.dp

class SpaceItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (parent.getChildAdapterPosition(view) != (parent.adapter?.itemCount ?: 0) - 1) {
        }
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = 24.dp()
        }
        outRect.bottom = 12.dp()
        outRect.left = 24.dp()
        outRect.right = 24.dp()

    }

}