package idv.kuma.interview.mkd.repository

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface GithubUserApi {
    @GET("/users")
    fun fetchUsers(@Query("since") since: Int): Single<Response<String>>
}