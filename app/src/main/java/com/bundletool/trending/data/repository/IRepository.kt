package com.bundletool.trending.data.repository

import com.bundletool.trending.data.entity.RepoList
import com.bundletool.trending.data.entity.ResultX

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   :
 */
interface IRepository {
    suspend fun getRepoList(): ResultX<RepoList>
}