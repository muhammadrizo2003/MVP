package com.example.androidmvp.activities

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmvp.R
import com.example.androidmvp.adapters.PostAdapter
import com.example.androidmvp.models.Post
import com.example.androidmvp.presenter.MainPresenter
import com.example.androidmvp.view.MainView

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var recyclerView: RecyclerView
    lateinit var mainPresenter: MainPresenter
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        context = this
        mainPresenter = MainPresenter(this)
        recyclerView = findViewById(R.id.main_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        mainPresenter.apiPostList()
    }

    private fun refreshAdapter(posters: ArrayList<Post>) {
        val adapter = PostAdapter(this, posters)
        recyclerView.adapter = adapter
    }

    override fun onPostListSuccess(posts: ArrayList<Post>?) {
        refreshAdapter(posts!!)
    }

    override fun onPostListFailure(error: Throwable) {
        TODO("Not yet implemented")
    }

    override fun onPostDeleteSuccess(post: Post?) {
        mainPresenter.apiPostList()
    }

    override fun onPostDeleteFailure(error: Throwable) {
        TODO("Not yet implemented")
    }
}

