package idv.kuma.interview.mkd.fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import idv.kuma.interview.mkd.GlideApp
import idv.kuma.interview.mkd.GlideOptions
import idv.kuma.interview.mkd.R
import idv.kuma.interview.mkd.data.User
import kotlinx.android.synthetic.main.adapter_user_list.view.*

class UserListAdapter(var userList: List<User>, var loadmore: Boolean, val callback: () -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class UserItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    class LoadMoreItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    class ViewType {
        companion object {
            val GENERAL = 0
            val LOADMORE = 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            when (viewType) {
                ViewType.GENERAL -> R.layout.adapter_user_list
                ViewType.LOADMORE -> R.layout.adapter_list_loadmore
                else -> R.layout.adapter_list_loadmore
            }, null)

        view.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
        return when (viewType) {
            ViewType.GENERAL -> UserItemViewHolder(view)
            else -> LoadMoreItemViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return userList.size + if (loadmore) 1 else 0
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == userList.size) {
            ViewType.LOADMORE
        } else {
            ViewType.GENERAL
        }
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        if (holder is LoadMoreItemViewHolder) {
            callback()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UserItemViewHolder -> {
                GlideApp
                    .with(holder.itemView.context)
                    .applyDefaultRequestOptions(GlideOptions.circleCropTransform())
                    .load(userList[position].avatarUrl)
                    .into(holder.itemView.imageUserPhoto)
                holder.itemView.textUserName.text = userList[position].login
                holder.itemView.textUserLabel.visibility = if (userList[position].siteAdmin) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }
            else -> {

            }
        }
    }
}