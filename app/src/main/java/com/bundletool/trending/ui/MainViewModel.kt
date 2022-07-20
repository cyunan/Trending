package com.bundletool.trending.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bundletool.trending.data.entity.RepoList
import com.bundletool.trending.data.entity.ResultX
import com.bundletool.trending.domain.GetRepoListUseCase
import kotlinx.coroutines.launch

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   : 表现层-ViewModel
 */
class MainViewModel(
    val getRepoListUseCase: GetRepoListUseCase = GetRepoListUseCase()
) : ViewModel() {
    val repos: LiveData<RepoList>
        get() = _repos
    private val _repos = MutableLiveData<RepoList>()

    fun loadRepos() {
        viewModelScope.launch {
            when (val result = getRepoListUseCase()) {
                is ResultX.Success -> {
                    _repos.value = result.data
                }
                is ResultX.Error -> {
                    _repos.value = RepoList()
                }
                ResultX.Loading -> {
                    // 展示Loading
                }
            }
        }
    }
}