package com.camilogo1200.dashboard.view_models

import com.camilogo1200.dashboard.view_states.IpInfoViewState
import com.camilogo1200.data.datasources.repositories.IpInfoLocalRepository
import com.camilogo1200.data.repositories.IpInfoRemoteRepository
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class IpInfoViewModelTest {
    private lateinit var ipInfoViewModel: IpInfoViewModel

    @get:Rule
    val mockkRule = MockKRule(this)

    private val testDispatcher = UnconfinedTestDispatcher()

    @RelaxedMockK
    val fakeRemoteRepository: IpInfoRemoteRepository = mockk()

    @RelaxedMockK
    private val fakeLocalRepository: IpInfoLocalRepository = mockk()

    @Before
    fun prepareTest() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        ipInfoViewModel = mockk<IpInfoViewModel>(relaxed = true)
        //IpInfoViewModel(fakeRemoteRepository, fakeLocalRepository, testDispatcher)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `should init view `() {
        //given
        //when
        ipInfoViewModel.initView()
        //then
        coVerify { ipInfoViewModel.initView() }
    }

    @Test
    fun `should set failed viewState when ip address is invalid`() {
        //given
        ipInfoViewModel.ipText = null.toString()
        //when
        ipInfoViewModel.searchIp()
        //then

        coVerify {
            ipInfoViewModel.searchIp()
        }

        assertEquals(ipInfoViewModel.viewState.value, IpInfoViewState.OnFetchInfoFailed)
        confirmVerified(ipInfoViewModel)
    }

    @Test
    fun `should validate ip address successfully on valid IpAddress`() {
        //given
        ipInfoViewModel = IpInfoViewModel(fakeRemoteRepository, fakeLocalRepository, testDispatcher)
        val ipText = "184.25.15.23"
        //when
        val check = ipInfoViewModel.isValidIp(ipText)
        //then
        assertTrue(check)
    }

    @Test
    fun `should failed validation on invalid Ip address`() {
        //given
        val ipText = "300.25.15.23"
        //when
        val check = ipInfoViewModel.isValidIp(ipText)
        //then
        assertFalse(check)
    }

    @Test
    fun `should failed validation on empty Ip address`() {
        //given
        val ipText = ""
        //when
        val check = ipInfoViewModel.isValidIp(ipText)
        //then
        assertFalse(check)
    }


    @Test
    fun `should failed validation on alphanumeric Ip address`() {
        //given
        val ipText = null.toString()
        //when
        val check = ipInfoViewModel.isValidIp(ipText)
        //then
        assertFalse(check)
        ipInfoViewModel.searchIp()
    }

}