package com.bundletool.trending.data.source

import com.bundletool.trending.data.entity.RepoList
import com.bundletool.trending.data.entity.ResultX

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   : 数据层-网络请求API
 */
interface RepoDataSource {
    suspend fun getRepos(): ResultX<RepoList>
}