package uk.co.madmouse.tadhack.sipcentricpbx.ui.sms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.sms_fragment.*
import uk.co.madmouse.iot.smsbridge.core.network.ResourceStatusEnum
import uk.co.madmouse.tadhack.sipcentricapi.model.local.SmsItem
import uk.co.madmouse.tadhack.sipcentricapi.model.local.SmsMessage
import uk.co.madmouse.tadhack.sipcentricpbx.R

class SmsFragment : Fragment() {
    private val CUSTOMER_ID = "CUSTOMER ID"
    private val DEFAULT_FROM = "<Simwood Number>"
    private val DEFAULT_TO = "<set Destination No>"
    private val DEFAULT_MSG = "Sample Message from Sip Centric PBX."
    companion object {
        fun newInstance() = SmsFragment()
    }

    private lateinit var viewModel: SmsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sms_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SmsViewModel::class.java)

        smsRecyclerView.apply {
            adapter =
                context?.let { SmsAdapter(ArrayList<SmsItem>()) }
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        viewModel.smsList.observe(viewLifecycleOwner, {
            smsRecyclerViewRefresh.isRefreshing = false
            it?.let { resource ->
                when (resource.status) {
                    ResourceStatusEnum.SUCCESS -> {
                        smsRecyclerViewEmpty.visibility = View.GONE
                        smsRecyclerView.adapter = SmsAdapter(resource.data?.items)
                    }
                    ResourceStatusEnum.ERROR -> {
                        smsRecyclerViewEmpty.visibility = View.VISIBLE
                        smsRecyclerView.adapter = SmsAdapter(ArrayList<SmsItem>())
                    }
                }
            }
        })
        viewModel.fetchSmsList(CUSTOMER_ID)
        send_to.setText(DEFAULT_TO)
        send_text.setText(DEFAULT_MSG)

        smsRecyclerViewRefresh.setOnRefreshListener {
            smsRecyclerViewRefresh.isRefreshing = true
            viewModel.fetchSmsList(CUSTOMER_ID)
        }

        sendButton.setOnClickListener({
            viewModel.sendSms(CUSTOMER_ID, SmsMessage(DEFAULT_FROM,send_to.text.toString(),send_text.text.toString()))
        })
    }

}