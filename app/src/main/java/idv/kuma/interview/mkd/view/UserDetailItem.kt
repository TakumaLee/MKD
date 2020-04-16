package idv.kuma.interview.mkd.view

import android.content.Context
import android.text.util.Linkify
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import idv.kuma.interview.mkd.R
import kotlinx.android.synthetic.main.item_user_detail.view.*

class UserDetailItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var iconRes: Int = 0
    var title: String = ""
    var isWeb: Boolean = false
    var isSiteAdmin: Boolean = false

    init {
        inflate(context, R.layout.item_user_detail, this)
        attrs?.let {
            val a = context.obtainStyledAttributes(attrs, R.styleable.UserDetailItem)
            iconRes = a.getResourceId(R.styleable.UserDetailItem_udiIcon, R.drawable.ic_close_black_24dp)
            title = a.getString(R.styleable.UserDetailItem_udiTitle) ?: ""
            isWeb = a.getBoolean(R.styleable.UserDetailItem_udiIsWeb, false)
            isSiteAdmin = a.getBoolean(R.styleable.UserDetailItem_udiSiteAdmin, false)
            a.recycle()
        }
        updateUI()
    }

    private fun updateUI() {
        imageUserDetailItemIcon.setImageResource(iconRes)
        textUserDetailItemTitle.text = title
        textUserDetailLabel.visibility = if (isSiteAdmin) View.VISIBLE else View.GONE
        if (isWeb) {
            Linkify.addLinks(textUserDetailItemTitle, Linkify.WEB_URLS)
        }
    }

    fun updateTitle(s: String) {
        title = s
        updateUI()
    }

    fun updateSiteAdmin(isAdmin: Boolean) {
        isSiteAdmin = isAdmin
        updateUI()
    }

    fun updateIsWeb(isWeb: Boolean) {
        this.isWeb = isWeb
        updateUI()
    }


}