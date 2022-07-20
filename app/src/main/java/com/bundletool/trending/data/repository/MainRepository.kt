package com.bundletool.trending.data.repository

import com.bundletool.trending.data.entity.RepoList
import com.bundletool.trending.data.entity.ResultX
import com.bundletool.trending.data.source.RepoDataSource
import com.bundletool.trending.data.source.remote.RemoteRepoDataSource

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   : 数据仓库：用于统筹缓存数据、远程数据
 */
class MainRepository(
    private val dataSource: RepoDataSource = RemoteRepoDataSource,
    private val localDataSource: RepoDataSource? = null
) : IRepository {
    override suspend fun getRepoList(): ResultX<RepoList> {
        // 暂不处理缓存逻辑
        return dataSource.getRepos()
    }
}