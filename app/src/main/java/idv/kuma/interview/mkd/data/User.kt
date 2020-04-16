package idv.kuma.interview.mkd.data

class User(
    val id: Int,
    val login: String,
    val url: String,
    val htmlUrl: String,
    val avatarUrl: String,
    val siteAdmin: Boolean,
    val name: String = "",
    val blog: String = "",
    val location: String = ""
) {
}