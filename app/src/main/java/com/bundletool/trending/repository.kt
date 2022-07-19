package com.bundletool.trending

import com.bundletool.trending.bean.RepoList

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   : 数据层
 */

interface RepoDataSource{
    suspend fun getRepos(): ResultX<RepoList>
}
interface IRepository {
    suspend fun getRepoList(): ResultX<RepoList>
}