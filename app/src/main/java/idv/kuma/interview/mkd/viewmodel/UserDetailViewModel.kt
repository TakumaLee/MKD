package idv.kuma.interview.mkd.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import idv.kuma.interview.mkd.data.User
import idv.kuma.interview.mkd.repository.UserRepoProvider

class UserDetailViewModel(val userProvider: UserRepoProvider) : ViewModel() {

    val user = MutableLiveData<User>().apply {
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun fetchUserDetail(username: String) {
        userProvider.fetchUserDetail(username) {
            user.value = it
        }
    }

}