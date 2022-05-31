package ru.netology.nmedia.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.intellij.lang.annotations.JdkConstants
import ru.netology.databinding.CardPostBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.viewmodel.PostViewModel

typealias OnLikeListener = (post: Post) -> Unit
//
//class PostsAdapter (private val onLikeListener: OnLikeListener): RecyclerView.Adapter<PostViewHolder>(){
//    var list = emptyList<Post>()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
//        val binding = CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return PostViewHolder(binding, onLikeListener)
//    }
//
//    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
//        val post = list[position]
//        holder.bind(post)
//    }
//
//    override fun getItemCount(): Int = list.size
//}

class PostsAdapter(
    private val onLikeListener: OnLikeListener
) : ListAdapter<Post, PostViewHolder>(PostDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding, onLikeListener)
    }

    override fun onBingViewHolder(holder: PostViewHolder, position: Int){
        val post = getItem(position)
        holder.bind(post)
    }
}