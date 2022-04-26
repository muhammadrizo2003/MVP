package com.example.androidmvp.view

import com.example.androidmvp.models.Post

interface MainView {
    fun onPostListSuccess(posts: ArrayList<Post>?)
    fun onPostListFailure(error: Throwable)

    fun onPostDeleteSuccess(post: Post?)
    fun onPostDeleteFailure(error: Throwable)
}

