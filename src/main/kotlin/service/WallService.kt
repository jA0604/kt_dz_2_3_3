package service

import model.Likes
import model.Post

class WallService {

    var id = 0

    var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        val copy = post.copy(id = id++)
        posts += copy
        return copy
    }

    fun remove(removeId: Int): Int {
        val postWithoutId = posts.filterIndexed { index, s -> (index != removeId)}
        posts = postWithoutId.toTypedArray()
        return --id
    }

    fun likeById(id: Int): Int {
        posts.forEachIndexed { index, post ->
            if (index == id) {
                val countLikes = posts[index].likes.countLikes + 1
                val countDislakes = posts[index].likes.countDislikes
                posts[index] = posts[index].copy(likes = Likes(countLikes, countDislakes))
                return posts[index].likes.countLikes
            }
        }
        return 0
    }

    fun dislikeById(id: Int): Int {
        for (post in posts) {
            if (post.id == id) {
                val countLikes = posts[id].likes.countLikes
                val countDislakes = posts[id].likes.countDislikes + 1
                posts[id] = posts[id].copy(likes = Likes(countLikes, countDislakes))
                return posts[id].likes.countDislikes
            }
        }
        return 0
    }

    fun sizeWallPosts() = posts.size

    fun update(post: Post): Boolean {
        posts.map {
            if (it.id == post.id) {
                val itId = it.id
                val itOwnerId = it.ownerId
                val itDate = it.date
                val copy = post.copy(id = itId, ownerId = itOwnerId, date = itDate)
                posts.set(itId, copy)
                return true
            }
        }
        return false
    }

    fun get(id: Int) = posts[id]

}