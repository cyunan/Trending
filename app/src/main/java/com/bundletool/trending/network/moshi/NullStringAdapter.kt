package com.bundletool.trending.network.moshi

import com.squareup.moshi.*


/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   : Repo 中所有的成员都定义成“非空类型”以后，当 API 不返回某个字段的时候，
 *    程序是可以自动填充默认值的。但是，当 API 强行在接口当中返回 null 的时候，程序还是会崩溃
 *
 *    所以需要为 JSON 解析框架 Moshi，配置一个额外的规则
 */

object NullStringAdapter {
    @FromJson
    fun fromJson(reader: JsonReader): String {
        if (reader.peek() != JsonReader.Token.NULL) {
            return reader.nextString()
        }
        reader.nextNull<Unit>()
        return ""
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: String?) {
        writer.value(value)
    }
}