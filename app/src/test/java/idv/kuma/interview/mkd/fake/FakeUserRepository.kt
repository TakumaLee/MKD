package idv.kuma.interview.mkd.fake

import idv.kuma.interview.mkd.data.User
import idv.kuma.interview.mkd.repository.UserRepoProvider

class FakeUserRepository : UserRepoProvider {
    override fun fetchUserList(callback: (List<User>) -> Unit) {
        callback(arrayListOf(
            User(),
            User(),
            User(),
            User(),
            User()
        ))
    }
}