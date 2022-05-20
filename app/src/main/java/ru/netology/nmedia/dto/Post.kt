package ru.netology.nmedia.dto

data class Post (
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likedByMe: Boolean = false,
    var likes:Int,
    var shares:Int){

}