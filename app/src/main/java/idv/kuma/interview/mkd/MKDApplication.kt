package idv.kuma.interview.mkd

import android.app.Application
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class MKDApplication : Application() {

    lateinit var okHttpClient: OkHttpClient

    override fun onCreate() {
        super.onCreate()
        okHttpClient = OkHttpClient.Builder()
            .connectTimeout(40, TimeUnit.SECONDS)
            .callTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .build()
    }

}