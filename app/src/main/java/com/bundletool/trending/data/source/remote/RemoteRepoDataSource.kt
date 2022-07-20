package com.bundletool.trending.data.source.remote

import android.util.Log
import com.bundletool.trending.data.entity.RepoList
import com.bundletool.trending.data.entity.ResultX
import com.bundletool.trending.data.entity.ResultX.*
import com.bundletool.trending.data.source.RepoDataSource
import com.bundletool.trending.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   : 数据层-处理远程数据源
 */
object RemoteRepoDataSource : RepoDataSource {
    const val TAG = "RemoteRepoDataSource"
    override suspend fun getRepos(): ResultX<RepoList> =
        withContext(Dispatchers.IO) {
            try {
                Success(RetrofitClient.service.repos())
            } catch (e: Exception) {
                Log.e(TAG, e.message, e)
                Error(e)
            }
        }
}