package idv.kuma.interview.mkd.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import idv.kuma.interview.mkd.data.User
import idv.kuma.interview.mkd.repository.UserRepoProvider

class UserViewModel(val userProvider: UserRepoProvider) : ViewModel() {

    val userList = MutableLiveData<List<User>>().apply {
        value = arrayListOf()
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun fetchUserList() {
        userProvider.fetchUserList {
            userList.value = it
        }
    }

}