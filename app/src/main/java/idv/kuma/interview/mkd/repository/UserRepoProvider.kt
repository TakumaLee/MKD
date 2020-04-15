package idv.kuma.interview.mkd.repository

import idv.kuma.interview.mkd.data.User

interface UserRepoProvider {
    fun fetchUserList(callback: (List<User>) -> Unit)
}