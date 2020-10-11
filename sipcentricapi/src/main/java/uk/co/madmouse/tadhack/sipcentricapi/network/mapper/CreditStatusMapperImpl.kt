package uk.co.madmouse.tadhack.sipcentricapi.network.mapper

import uk.co.madmouse.tadhack.sipcentricapi.model.remote.CreditStatusItem

class CreditStatusMapperImpl :
    NetworkMapper<CreditStatusItem, uk.co.madmouse.tadhack.sipcentricapi.model.local.CreditStatusItem> {
    override fun map(inClass: CreditStatusItem?): uk.co.madmouse.tadhack.sipcentricapi.model.local.CreditStatusItem? {
        return uk.co.madmouse.tadhack.sipcentricapi.model.local.CreditStatusItem(
            inClass?.accountType,
            inClass?.type,
            inClass?.uri,
            inClass?.balance
        );
    }
}