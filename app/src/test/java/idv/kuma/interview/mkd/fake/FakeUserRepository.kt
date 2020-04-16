package idv.kuma.interview.mkd.fake

import idv.kuma.interview.mkd.data.User
import idv.kuma.interview.mkd.repository.UserRepoProvider

class FakeUserRepository : UserRepoProvider {

    override fun fetchUserList(since: Int, perPage: Int, callback: (List<User>) -> Unit) {
        callback(arrayListOf(
            User(0, "", "", "", "", false),
            User(1, "", "", "", "", false),
            User(2, "", "", "", "", false),
            User(3, "", "", "", "", false),
            User(4, "", "", "", "", false)
        ))
    }
}