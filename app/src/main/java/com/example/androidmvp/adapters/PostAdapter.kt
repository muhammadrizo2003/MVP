package com.example.androidmvp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmvp.utils.Utils
import com.example.androidmvp.R
import com.example.androidmvp.activities.MainActivity
import com.example.androidmvp.models.Post

class PostAdapter(private val activity: MainActivity, private val list: ArrayList<Post>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_poster_list, parent, false)
        return PostViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post = list[position]

        if (holder is PostViewHolder) {
            val postViewHolder = (holder as PostViewHolder)

            postViewHolder.textViewTitle.text = post.title
            postViewHolder.textViewBody.text = post.body

            postViewHolder.itemContainerLayout.setOnLongClickListener {
                dialogForDeletePost(post)
                true
            }
        }
    }

    override fun getItemCount() = list.size

    private class PostViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val textViewTitle: TextView = itemView.findViewById(R.id.tv_title)
        val textViewBody: TextView = itemView.findViewById(R.id.tv_body)
        val itemContainerLayout: LinearLayout = itemView.findViewById(R.id.item_container_layout)
    }

    private fun dialogForDeletePost(post: Post) {
        val title = "Delete"
        val body = "Do you want to delete?"
        Utils.customDialog(activity, title, body, object : Utils.DialogListener {
            override fun onPositiveClick() {
                activity.mainPresenter.apiPostDelete(post)
            }

            override fun onNegativeClick() {
                TODO("Not yet implemented")
            }
        })
    }
}

