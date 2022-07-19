package com.bundletool.trending.bean

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