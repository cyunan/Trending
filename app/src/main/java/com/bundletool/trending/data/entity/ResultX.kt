
package com.bundletool.trending.data.entity

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   : 密封类：统一不同情况下返回的数据形式
 */

sealed class ResultX<out R: Any> {

    data class Success<out T: Any>(val data: T) : ResultX<T>()
    data class Error(val exception: Exception) : ResultX<Nothing>()
    object Loading : ResultX<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

