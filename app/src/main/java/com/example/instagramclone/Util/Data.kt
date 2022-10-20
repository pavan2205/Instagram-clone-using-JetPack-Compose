package com.example.instagramclone

import android.net.Uri

object DummyData {
    val reels = listOf<Reel>(
        Reel(
            id = 1,
            video = "lake.mp4",
            userImage = "https://generated.photos/vue-static/home/hero/4.png",
            userName = "Marcus clarke",
            isLiked = true,
            likesCount = 678,
            commentsCount = 156,
            comment = "Cool Place 🙌..."
        ),
        Reel(
            id = 2,
            video = "food.mp4",
            userImage = "https://generated.photos/vue-static/home/hero/7.png",
            userName = "Emily",
            isLiked = true,
            likesCount = 5923,
            commentsCount = 11,
            comment = "delicious"
        ),
        Reel(
            id = 3,
            video = "icecream.mp4",
            userImage = "https://generated.photos/vue-static/home/hero/3.png",
            userName = "Liva sage",
            isLiked = true,
            likesCount = 9314,
            comment = "yummy..🤤",
            commentsCount = 200
        ),
        Reel(
            id = 4,
            video = "soap-bubbles.mp4",
            userImage = "https://generated.photos/vue-static/home/hero/6.png",
            userName = "Robert evans",
            isLiked = true,
            likesCount = 786,
            comment = "💙",
            commentsCount = 700
        ),
    )
}

data class Reel(
    val id: Int,
    private val video: String,
    val userImage: String,
    val userName: String,
    val isLiked: Boolean = false,
    val likesCount: Int,
    val comment: String,
    val commentsCount: Int
) {

    fun getVideoUrl(): Uri {
        return Uri.parse("asset:///${video}")
    }

}