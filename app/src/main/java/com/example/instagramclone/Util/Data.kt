package com.example.instagramclone

import android.net.Uri

object DummyData {
    val reels = listOf<Reel>(
        Reel(
            id = 1,
            video = "video.mp4",
            userImage = R.drawable.ckay,
            userName = "Farhan Roy",
            isLiked = true,
            likesCount = 778,
            commentsCount = 156,
            comment = "Wkwkwk..."
        ),
        Reel(
            id = 2,
            video = "video.mp4",
            userImage = R.drawable.ckay,
            userName = "Muhammad Ali",
            isLiked = true,
            likesCount = 5923,
            commentsCount = 11,
            comment = "Awas kamu ya klo pergi"
        ),
        Reel(
            id = 3,
            video = "video.mp4",
            userImage = R.drawable.ckay,
            userName = "Christian Juned",
            isLiked = true,
            likesCount = 2314,
            comment = "Es krim dingin sedapp",
            commentsCount = 200
        ),
        Reel(
            id = 4,
            video = "video.mp4",
            userImage = R.drawable.ckay,
            userName = "Cak Jhon",
            isLiked = true,
            likesCount = 786,
            comment = "Ados slurr",
            commentsCount = 700
        ),
        Reel(
            id = 5,
            video = "video.mp4",
            userImage = R.drawable.ckay,
            userName = "David Dulkader",
            isLiked = true,
            likesCount = 1890,
            comment = "Kerjaan di tengah hutan",
            commentsCount = 232
        )

    )
}

data class Reel(
    val id: Int,
    private val video: String,
    val userImage: Int,
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