package uk.co.madmouse.tadhack.sipcentricapi.model.remote

import com.google.gson.annotations.SerializedName

data class SmsItem(

	@field:SerializedName("parent")
	val parent: String? = null,

	@field:SerializedName("cost")
	val cost: Double? = null,

	@field:SerializedName("created")
	val created: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("uri")
	val uri: String? = null,

	@field:SerializedName("creditsUsed")
	val creditsUsed: Int? = null,

	@field:SerializedName("from")
	val from: String? = null,

	@field:SerializedName("sendStatus")
	val sendStatus: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("to")
	val to: String? = null,

	@field:SerializedName("deliveryStatus")
	val deliveryStatus: Int? = null,

	@field:SerializedName("direction")
	val direction: String? = null
)
