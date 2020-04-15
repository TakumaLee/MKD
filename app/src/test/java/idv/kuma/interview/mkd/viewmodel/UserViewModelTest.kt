package idv.kuma.interview.mkd.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import idv.kuma.interview.mkd.fake.FakeUserRepository
import idv.kuma.interview.mkd.repository.UserRepoProvider
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class UserViewModelTest {
    @Rule
    @JvmField
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var userRepoProvider: UserRepoProvider
    lateinit var userViewModel: UserViewModel

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        userRepoProvider = FakeUserRepository()
        userViewModel = UserViewModel(userRepoProvider)
    }

    @Test
    fun `test user size`() {
        assertEquals(0, userViewModel.userList.value?.size)
        userViewModel.fetchUserList()
        assertEquals(5, userViewModel.userList.value?.size)
    }

}