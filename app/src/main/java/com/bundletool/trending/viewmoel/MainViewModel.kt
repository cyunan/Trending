package com.bundletool.trending.viewmoel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bundletool.trending.GetRepoListUseCase
import com.bundletool.trending.ResultX
import com.bundletool.trending.bean.RepoList
import kotlinx.coroutines.launch

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   :
 */
class MainViewModel(
    val getRepoListUseCase: GetRepoListUseCase = GetRepoListUseCase()
): ViewModel() {

    val repos: LiveData<RepoList>
        get() = _repos
    private val _repos = MutableLiveData<RepoList>()

    fun loadRepos(){
        viewModelScope.launch {
            val result = getRepoListUseCase()
            when(result){
                is ResultX.Success -> {
                    _repos.value = result.data
                }
                is ResultX.Error ->{
                    _repos.value = RepoList()
                }
                ResultX.Loading -> {
                    //展示Loading[
                }
            }
        }
    }
}