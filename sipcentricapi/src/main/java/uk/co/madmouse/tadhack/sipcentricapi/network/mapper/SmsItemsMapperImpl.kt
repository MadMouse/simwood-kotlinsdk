package uk.co.madmouse.tadhack.sipcentricapi.network.mapper

import uk.co.madmouse.tadhack.sipcentricapi.model.local.SmsItem
import uk.co.madmouse.tadhack.sipcentricapi.model.local.SmsItems

class SmsItemsMapperImpl :
    NetworkMapper<uk.co.madmouse.tadhack.sipcentricapi.model.remote.SmsItems, SmsItems> {

    override fun map(inClass: uk.co.madmouse.tadhack.sipcentricapi.model.remote.SmsItems?): SmsItems? {
        inClass?.let {
            val smsItems = ArrayList<SmsItem>();
            it.items?.let { items ->
                for (smsItem in it.items) {
                    smsItems.add(
                        SmsItem(
                            smsItem?.parent,
                            smsItem?.cost,
                            smsItem?.created,
                            smsItem?.type,
                            smsItem?.body,
                            smsItem?.uri,
                            smsItem?.creditsUsed,
                            smsItem?.from,
                            smsItem?.sendStatus,
                            smsItem?.id,
                            smsItem?.to,
                            smsItem?.deliveryStatus,
                            smsItem?.direction
                        )
                    )
                }
            }
            return SmsItems(
                it.totalItems,
                it.pageSize,
                it.page,
                smsItems
            )
        }
        return null
    }
}