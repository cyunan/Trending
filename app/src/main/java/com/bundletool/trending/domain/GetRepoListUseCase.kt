package com.bundletool.trending.domain

import com.bundletool.trending.data.entity.RepoList
import com.bundletool.trending.data.entity.ResultX
import com.bundletool.trending.data.repository.IRepository
import com.bundletool.trending.data.repository.MainRepository

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   : 领域层：业务逻辑的一个小单元
 */
class GetRepoListUseCase(private val repository: IRepository = MainRepository()) {
    suspend operator fun invoke(): ResultX<RepoList> {
        return repository.getRepoList()
    }
}