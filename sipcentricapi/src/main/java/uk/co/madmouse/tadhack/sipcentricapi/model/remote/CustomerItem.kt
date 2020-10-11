package uk.co.madmouse.tadhack.sipcentricapi.model.remote

import com.google.gson.annotations.SerializedName

class CustomerItem (
    @field:SerializedName("firstName")
    val firstName: String? = null,

    @field:SerializedName("lastName")
    val lastName: String? = null,

    @field:SerializedName("created")
    val created: String? = null,

    @field:SerializedName("company")
    val company: String? = null,

    @field:SerializedName("links")
    val links: CustomerLinkItem? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("uri")
    val uri: String? = null,

    @field:SerializedName("userEmailUpdatable")
    val userEmailUpdatable: Boolean? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("enabled")
    val enabled: Boolean? = null
)