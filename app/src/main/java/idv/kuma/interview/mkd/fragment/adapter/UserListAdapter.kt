package idv.kuma.interview.mkd.fragment.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import idv.kuma.interview.mkd.GlideApp
import idv.kuma.interview.mkd.GlideOptions
import idv.kuma.interview.mkd.R
import idv.kuma.interview.mkd.data.User
import kotlinx.android.synthetic.main.adapter_user_list.view.*

class UserListAdapter(var userList: List<User>) : RecyclerView.Adapter<UserListAdapter.UserItemViewHolder>() {

    class UserItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_user_list, null)
        view.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
        return UserItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
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
}