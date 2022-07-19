package com.bundletool.trending

import com.bundletool.trending.bean.RepoList

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   :
 */
class MainRepository(
    private val dataSource: RepoDataSource = RemoteDataSource,
    private val localSource: RepoDataSource? = null,
): IRepository {
    override suspend fun getRepoList(): ResultX<RepoList> {
        return dataSource.getRepos()
    }

}