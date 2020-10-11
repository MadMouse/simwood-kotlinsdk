package uk.co.madmouse.tadhack.sipcentricapi.model.local

import com.google.gson.annotations.SerializedName

class SmsItem (
    val parent: String? = null,

    val cost: Double? = null,

    val created: String? = null,

    val type: String? = null,

    val body: String? = null,

    val uri: String? = null,

    val creditsUsed: Int? = null,

    val from: String? = null,

    val sendStatus: String? = null,

    val id: String? = null,

    val to: String? = null,

    val deliveryStatus: Int? = null,

    val direction: String? = null
)