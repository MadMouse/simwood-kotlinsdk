package uk.co.madmouse.tadhack.sipcentricpbx.ui.sms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uk.co.madmouse.tadhack.sipcentricapi.model.local.SmsItem
import uk.co.madmouse.tadhack.sipcentricpbx.R

class SmsAdapter(private val smsList: List<SmsItem?>?) :
    RecyclerView.Adapter<SmsAdapter.SmsItemViewHolder>() {

    class SmsItemViewHolder : RecyclerView.ViewHolder {
        val smsFrom: TextView
        val smsCreated: TextView
        val smsBody: TextView
        val smsStatus: TextView

        constructor(itemView: View) : super(itemView) {
            smsFrom = itemView.findViewById(R.id.smsFrom)
            smsCreated = itemView.findViewById(R.id.smsCreated)
            smsBody = itemView.findViewById(R.id.smsBody)
            smsStatus = itemView.findViewById(R.id.smsStatus)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmsItemViewHolder {
        val rowView = LayoutInflater.from(parent.context)
            .inflate(R.layout.sms_list_item, parent, false)
        return SmsItemViewHolder(rowView)
    }

    private fun getDeliveryStatus(deliveryStatus: Int): String {
        when (deliveryStatus) {
            1 -> {
                return "Delivered to handset"
            }
            2 -> {
                return "Rejected from handset"
            }
            4 -> {
                return "Buffered in transit"
            }
            8 -> {
                return " Accepted by SMS carrier"
            }
            16 -> {
                return "Rejected by SMS carrier"
            }

        }
        return "Unkown"
    }

    override fun onBindViewHolder(holder: SmsItemViewHolder, position: Int) {
        val smsMessage = smsList?.get(position)
        smsMessage?.let {
            if (it.direction.equals("IN")) {
                holder.smsFrom.setText(it.from)
            } else {
                holder.smsFrom.setText(it.to)
            }
            holder.smsBody.setText(it.body)
            holder.smsCreated.setText(it.created)
            holder.smsStatus.setText(it.deliveryStatus?.let { getDeliveryStatus(it) })
        }
    }

    override fun getItemCount(): Int {
        return smsList?.size ?: 0
    }

}