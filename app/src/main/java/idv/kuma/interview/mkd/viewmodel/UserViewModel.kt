package idv.kuma.interview.mkd.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import idv.kuma.interview.mkd.data.User
import idv.kuma.interview.mkd.repository.UserRepoProvider

class UserViewModel(val userProvider: UserRepoProvider) : ViewModel() {

    private val PER_PAGE = 20
    private val LIMITED_USERS = 100
    val since = MutableLiveData<Int>().apply {
        value = 0
    }
    val userList = MutableLiveData<List<User>>().apply {
        value = arrayListOf()
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun fetchUserList() {
        Log.v("User Load", "${since.value}")
        userProvider.fetchUserList(since.value ?: 0, PER_PAGE) {
            userList.value = userList.value?.plus(it)
            since.value = since.value?.plus(it.size)
        }
    }

    fun isLimited() = since.value ?: 0 < LIMITED_USERS

}