package uk.co.madmouse.tadhack.sipcentricapi.model.local

import com.google.gson.annotations.SerializedName

data class SmsItems(
	val totalItems: Int? = null,

	val pageSize: Int? = null,

	val page: Int? = null,

	val items: List<SmsItem?>? = null
)
