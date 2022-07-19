package com.bundletool.trending

import com.bundletool.trending.bean.RepoList
import com.google.gson.annotations.Since
import retrofit2.http.Query

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   : 数据接口
 */
interface RepoService {
    suspend fun repos(
        @Query("lang") lang: String = "kotlin",
        @Query("since") since: String = "weekly"
    ): RepoList
}