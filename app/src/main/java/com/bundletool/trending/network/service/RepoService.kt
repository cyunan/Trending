package com.bundletool.trending.network.service

import com.bundletool.trending.data.entity.RepoList
import retrofit2.http.*

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   : 数据层-网络请求API
 */
interface RepoService {
    @GET("repo")
    suspend fun repos(): RepoList
}