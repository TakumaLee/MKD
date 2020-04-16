package idv.kuma.interview.mkd.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import idv.kuma.interview.mkd.GlideApp
import idv.kuma.interview.mkd.GlideOptions
import idv.kuma.interview.mkd.R
import idv.kuma.interview.mkd.viewmodel.UserDetailViewModel
import kotlinx.android.synthetic.main.adapter_user_list.view.*
import kotlinx.android.synthetic.main.fragment_user_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserDetailFragment : Fragment() {

    private val userDetailViewModel: UserDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            val username = getString("username") ?: ""
            userDetailViewModel.fetchUserDetail(username = username)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userDetailViewModel.user.observe(viewLifecycleOwner, Observer {
            GlideApp
                .with(view.context)
                .applyDefaultRequestOptions(GlideOptions.circleCropTransform())
                .load(it.avatarUrl)
                .into(imageUserDetailPhoto)
            textUserDetailName.text = it.name
            userDetailItem1.updateTitle(it.login)
            userDetailItem2.updateTitle(it.location)
            userDetailItem2.updateSiteAdmin(it.siteAdmin)
            userDetailItem3.updateTitle(it.blog)
            userDetailItem3.updateIsWeb(true)
        })

        imageUserDetailClose.setOnClickListener {
            it.findNavController().popBackStack()
        }
    }

}