package idv.kuma.interview.mkd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import idv.kuma.interview.mkd.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel.fetchUserList()

    }
}
