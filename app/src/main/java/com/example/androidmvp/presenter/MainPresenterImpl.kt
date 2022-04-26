package com.example.androidmvp.presenter

import com.example.androidmvp.models.Post

interface MainPresenterImpl {
    fun apiPostList()
    fun apiPostDelete(post: Post)
}

