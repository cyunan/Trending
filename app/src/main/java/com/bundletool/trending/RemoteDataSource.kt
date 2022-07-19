package com.bundletool.trending

import android.util.Log
import com.bundletool.trending.bean.RepoList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   : 数据处理
 */
object RemoteDataSource : RepoDataSource{
    const val TAG = "RemoteRepoDataSource"
    override suspend fun getRepos(): ResultX<RepoList> =
        withContext(Dispatchers.IO){
            try{
                ResultX.Success(RetrofitClient.service.repos())
            }catch (e: Exception){
                Log.e(TAG, e.message, e)
                ResultX.Error(e)
            }
        }
}