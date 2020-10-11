package uk.co.madmouse.tadhack.sipcentricapi.network.mapper

import uk.co.madmouse.tadhack.sipcentricapi.model.local.CustomerItem

interface NetworkMapper<InClass, OutClass> {
    fun map(inClass: InClass?): OutClass?
}