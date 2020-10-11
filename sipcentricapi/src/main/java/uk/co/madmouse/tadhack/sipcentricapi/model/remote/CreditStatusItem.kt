package uk.co.madmouse.tadhack.sipcentricapi.model.remote

import com.google.gson.annotations.SerializedName

data class CreditStatusItem(

	@field:SerializedName("accountType")
	val accountType: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("uri")
	val uri: String? = null,

	@field:SerializedName("balance")
	val balance: Double? = null
)
