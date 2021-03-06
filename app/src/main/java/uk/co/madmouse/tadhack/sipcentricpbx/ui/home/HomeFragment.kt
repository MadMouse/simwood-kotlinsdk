package uk.co.madmouse.tadhack.sipcentricpbx.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.nav_header_main.*
import uk.co.madmouse.iot.smsbridge.core.network.ResourceStatusEnum
import uk.co.madmouse.tadhack.sipcentricpbx.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        homeViewModel.myProfile.observe(viewLifecycleOwner, Observer {
            when(it.status){
                ResourceStatusEnum.SUCCESS -> {
                    activity?.accountCompany?.setText(it.data?.company)
                    activity?.accountEmail?.setText(it.data?.email)
                }
            }
        })


        homeViewModel.creditStatus.observe(viewLifecycleOwner, Observer {
            when(it.status){
                ResourceStatusEnum.SUCCESS -> {
                    activity?.accountBalance?.setText(String.format("%s :  %s",
                        it.data?.accountType,
                        it.data?.balance))
                }
            }
        })
        homeViewModel.fetchMyProfile()
        return root
    }
}