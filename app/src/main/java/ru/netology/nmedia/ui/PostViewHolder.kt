package ru.netology.nmedia.ui

import android.system.Os.remove
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import ru.netology.R
import ru.netology.databinding.CardPostBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.ui.OnInteractionListener

//import ru.netology.nmedia.ui.extraViewFunctions

class PostViewHolder(
    private val binding: CardPostBinding,
    private val listener: OnInteractionListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.apply {
            author.text = post.author
            published.text = post.published
            content.text = post.content
           // likesText.text = extraViewFunctions().stringNumberWithKInsteadOf1000(post.likes)
            like.text = extraViewFunctions().stringNumberWithKInsteadOf1000(post.likes)
            //sharesText.text = extraViewFunctions().stringNumberWithKInsteadOf1000(post.shares)
            share.text = extraViewFunctions().stringNumberWithKInsteadOf1000(post.shares)
//            like.setImageResource(
//                if (post.likedByMe) R.drawable.ic_like_24 else R.drawable.ic_like_border_24
//            )
            like.isChecked = post.likedByMe
            like.setOnClickListener {
                listener.onLike(post)
            }
            share.setOnClickListener {
                listener.onShare(post)
            }

            menu.setOnClickListener {
                PopupMenu(it.context, it).apply {
                    inflate(R.menu.options_post)
                    setOnMenuItemClickListener { item ->
                        when (item.itemId) {
                            R.id.remove -> {
                                listener.onRemove(post)
                                true
                            }
                            R.id.edit -> {
                                listener.onEdit(post)
                                true
                            }
                            else -> false
                        }

                    }
                }.show()
            }
        }
    }
}

