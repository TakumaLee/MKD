package idv.kuma.interview.mkd.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Space
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import idv.kuma.interview.mkd.R
import idv.kuma.interview.mkd.fragment.adapter.UserListAdapter
import idv.kuma.interview.mkd.view.SpaceItemDecoration
import idv.kuma.interview.mkd.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_user_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment : Fragment() {

    private val userViewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel.fetchUserList()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(recyclerUserList) {
            adapter = UserListAdapter(userViewModel.userList.value ?: emptyList())
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(SpaceItemDecoration())
        }

        userViewModel.userList.observe(viewLifecycleOwner, Observer {
            (recyclerUserList.adapter as UserListAdapter).userList = it
            recyclerUserList.adapter?.notifyItemRangeChanged(0, it.size)

        })
    }

}