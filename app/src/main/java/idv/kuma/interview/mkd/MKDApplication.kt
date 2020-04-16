package idv.kuma.interview.mkd

import android.app.Application
import idv.kuma.interview.mkd.repository.UserRepoProvider
import idv.kuma.interview.mkd.repository.UserRepository
import idv.kuma.interview.mkd.viewmodel.UserViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

class MKDApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MKDApplication)
            modules(appModule)
        }
    }

}

val appModule = module {
    single {
        OkHttpClient.Builder()
            .connectTimeout(40, TimeUnit.SECONDS)
            .callTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .build()
    }
    single<UserRepoProvider> {
        UserRepository(get())
    }
    viewModel {
        UserViewModel(get())
    }
}