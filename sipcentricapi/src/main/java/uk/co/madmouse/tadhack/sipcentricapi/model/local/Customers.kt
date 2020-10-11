package uk.co.madmouse.tadhack.sipcentricapi.model.local

data class Customers(

	val totalItems: Int? = null,

	val pageSize: Int? = null,

	val page: Int? = null,

	val items: List<CustomerItem?>? = null
)