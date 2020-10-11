package uk.co.madmouse.tadhack.sipcentricapi.network.mapper

import uk.co.madmouse.tadhack.sipcentricapi.model.local.CustomerItem
import uk.co.madmouse.tadhack.sipcentricapi.model.local.CustomerLinkItem
import java.text.ParseException

class CustomerItemMapperImpl :
    NetworkMapper<uk.co.madmouse.tadhack.sipcentricapi.model.remote.CustomerItem,
            CustomerItem> {
    fun mapCustomerLinks(customerLinkItem: uk.co.madmouse.tadhack.sipcentricapi.model.remote.CustomerLinkItem?): CustomerLinkItem {
        return CustomerLinkItem(
            customerLinkItem?.endpoints,
            customerLinkItem?.preferences,
            customerLinkItem?.outgoingCallerIds,
            customerLinkItem?.timeIntervals,
            customerLinkItem?.creditStatus,
            customerLinkItem?.phoneNumbers,
            customerLinkItem?.bargeGroups,
            customerLinkItem?.callBundles,
            customerLinkItem?.linkedUsers,
            customerLinkItem?.sounds,
            customerLinkItem?.recordings,
            customerLinkItem?.phoneBook,
            customerLinkItem?.calls
        )
    }

    override fun map(inClass: uk.co.madmouse.tadhack.sipcentricapi.model.remote.CustomerItem?): CustomerItem? {
        inClass?.let {
            return CustomerItem(
                it.firstName,
                it.lastName,
                it.created,
                it.company,
                it.links?.let { mapCustomerLinks(it) },
                it.id,
                it.type,
                it.uri,
                it.userEmailUpdatable,
                it.email,
                it.enabled
            )
        }
        return null
    }
}