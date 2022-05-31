package ru.netology.nmedia.ui

import androidx.recyclerview.widget.RecyclerView
import ru.netology.R
import ru.netology.databinding.CardPostBinding
import ru.netology.nmedia.dto.Post

class PostViewHolder (
    private val binding: CardPostBinding,
    private val onLikeListener: OnLikeListener
        ) : RecyclerView.ViewHolder(binding.root)    {
            fun bind(post: Post) {
                binding.apply {
                    author.text = post.author
                    published.text = post.published
                    content.text = post.content
                    likesImage.setImageResource(
                        if (post.likedByMe) R.drawable.ic_like_24 else R.drawable.ic_like_border_24
                    )
                    likesImage.setOnClickListener {
                        onLikeListener(post)
                    }
                }
            }
}