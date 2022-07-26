package com.bundletool.trending.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bundletool.trending.data.entity.RepoList
import com.bundletool.trending.databinding.ActivityMainBinding
import com.bundletool.trending.ui.adapter.RepoAdapter

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   :
 */
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RepoAdapter
    private val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.loadRepos()
        observeData()
    }

    private fun observeData() {
        viewModel.repos.observe(this) {
            display(it)
        }
    }

    private fun display(repoList: RepoList) {
        adapter = RepoAdapter(repoList)
        binding.recycler.layoutManager = layoutManager
        binding.recycler.adapter = adapter
    }
}