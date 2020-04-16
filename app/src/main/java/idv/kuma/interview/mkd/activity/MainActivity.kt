package idv.kuma.interview.mkd.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import idv.kuma.interview.mkd.R
import idv.kuma.interview.mkd.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
