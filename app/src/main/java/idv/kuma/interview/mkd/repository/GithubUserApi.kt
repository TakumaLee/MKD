package idv.kuma.interview.mkd.repository

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*

interface GithubUserApi {
    @GET("/users")
    fun fetchUsers(@Query("since") since: Int, @Query("per_page") perPage: Int): Single<Response<String>>

    @GET("/users/{username}")
    fun fetchUserDetail(@Path("username") username: String): Single<Response<String>>
}