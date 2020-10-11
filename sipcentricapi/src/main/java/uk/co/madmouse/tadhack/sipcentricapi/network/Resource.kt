package uk.co.madmouse.iot.smsbridge.core.network

data class Resource<out T>(val status: ResourceStatusEnum, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> =
            Resource(status = ResourceStatusEnum.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): Resource<T> =
            Resource(status = ResourceStatusEnum.ERROR, data = data, message = message)

        fun <T> loading(data: T?): Resource<T> =
            Resource(status = ResourceStatusEnum.LOADING, data = data, message = null)
    }
}