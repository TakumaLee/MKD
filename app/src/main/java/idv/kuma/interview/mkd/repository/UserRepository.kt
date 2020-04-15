package idv.kuma.interview.mkd.repository

import idv.kuma.interview.mkd.data.User

class UserRepository() : UserRepoProvider {
    override fun fetchUserList(callback: (List<User>) -> Unit) {

    }
}