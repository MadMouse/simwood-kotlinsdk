package uk.co.madmouse.tadhack.sipcentricapi.network.mapper

import uk.co.madmouse.tadhack.sipcentricapi.model.local.SmsItem

class SmsItemMapperImpl : NetworkMapper<
        uk.co.madmouse.tadhack.sipcentricapi.model.remote.SmsItem,
        SmsItem> {
    override fun map(inClass: uk.co.madmouse.tadhack.sipcentricapi.model.remote.SmsItem?): SmsItem? {
        return SmsItem(inClass?.parent,
            inClass?.cost,
            inClass?.created,
            inClass?.type,
            inClass?.body,
            inClass?.uri,
            inClass?.creditsUsed,
            inClass?.from,
            inClass?.sendStatus,
            inClass?.id,
            inClass?.to,
            inClass?.deliveryStatus,
            inClass?.direction)
    }

}