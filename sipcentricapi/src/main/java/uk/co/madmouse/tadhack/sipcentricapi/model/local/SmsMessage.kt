package uk.co.madmouse.tadhack.sipcentricapi.model.local

import com.google.gson.annotations.SerializedName
data class SmsMessage(

	@field:SerializedName("from")
	val from: String? = null,

	@field:SerializedName("to")
	val to: String? = null,

	@field:SerializedName("body")
	val body: String? = null
) {
	@field:SerializedName("type")
	val type: String = "smsmessage"
}
