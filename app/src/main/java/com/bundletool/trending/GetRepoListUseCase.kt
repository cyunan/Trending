package com.bundletool.trending

import com.bundletool.trending.bean.RepoList

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   :
 */
class GetRepoListUseCase(private val repository: IRepository = MainRepository()) {
    suspend operator fun invoke(): ResultX<RepoList>{
        return repository.getRepoList()
    }
}