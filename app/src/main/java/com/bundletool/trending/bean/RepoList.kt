package com.bundletool.trending.bean

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   :
 */

data class RepoList(
    val count: Int = 0,
    val items: List<Repo> = listOf(),
    val msg: String = "数据为空"
)


