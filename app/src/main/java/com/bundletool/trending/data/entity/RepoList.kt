package com.bundletool.trending.data.entity

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   : 实体类
 *    不变性思维：成员属性全部都是 val 定义的
 *    空安全思维：所有的类型都是不为空的
 */

data class RepoList(
    val count: Int = 0,
    val items: List<Repo> = listOf(),
    val msg: String = "数据为空"
)

data class Repo(
    val added_stars: String = "",
    val avatars: List<String> = listOf(),
    val desc: String = "",
    val forks: String = "",
    val lang: String = "",
    val repo: String = "",
    val repo_link: String = "",
    val stars: String = ""
)
