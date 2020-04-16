package idv.kuma.interview.mkd.repository

import idv.kuma.interview.mkd.data.User

interface UserRepoProvider {
    fun fetchUserList(since: Int, perPage: Int, callback: (List<User>) -> Unit)
    fun fetchUserDetail(username: String, callback: (User) -> Unit)
}