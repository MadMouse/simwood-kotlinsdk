package uk.co.madmouse.tadhack.sipcentricapi.model.remote

import com.google.gson.annotations.SerializedName

data class Customers(

	@field:SerializedName("totalItems")
	val totalItems: Int? = null,

	@field:SerializedName("pageSize")
	val pageSize: Int? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("items")
	val items: List<CustomerItem?>? = null
)