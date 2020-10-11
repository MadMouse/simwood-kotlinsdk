package uk.co.madmouse.tadhack.sipcentricapi.model.remote

import com.google.gson.annotations.SerializedName

data class CustomerLinkItem(

	@field:SerializedName("endpoints")
	val endpoints: String? = null,

	@field:SerializedName("preferences")
	val preferences: String? = null,

	@field:SerializedName("outgoingCallerIds")
	val outgoingCallerIds: String? = null,

	@field:SerializedName("timeIntervals")
	val timeIntervals: String? = null,

	@field:SerializedName("creditStatus")
	val creditStatus: String? = null,

	@field:SerializedName("phoneNumbers")
	val phoneNumbers: String? = null,

	@field:SerializedName("bargeGroups")
	val bargeGroups: String? = null,

	@field:SerializedName("callBundles")
	val callBundles: String? = null,

	@field:SerializedName("linkedUsers")
	val linkedUsers: String? = null,

	@field:SerializedName("sounds")
	val sounds: String? = null,

	@field:SerializedName("recordings")
	val recordings: String? = null,

	@field:SerializedName("phoneBook")
	val phoneBook: String? = null,

	@field:SerializedName("calls")
	val calls: String? = null,

	@field:SerializedName("sms")
	val sms: String? = null
)
