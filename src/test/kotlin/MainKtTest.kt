import model.*
import org.junit.Assert.*
import org.junit.Test
import service.WallService

class MainKtTest {
    private val service = WallService()

    @Test
    fun addPost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        val expected = Post (
            id = 1,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        service.add(post)
        val result = service.add(post)
        assertEquals(expected.id, result.id)

    }

    @Test
    fun likePost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        val expected = 1

        var copy = service.add(post)
        copy = service.add(copy)

        val result = service.likeById(1)
        assertEquals(expected, result)

    }

    @Test
    fun removePost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        val expected = 2

        var copy = service.add(post)
        copy = service.add(copy)
        copy = service.add(copy)
        service.remove(1)

        val result = service.sizeWallPosts()
        assertEquals(expected, result)
    }

    @Test
    fun dislikePost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        val expected = 2

        var copy = service.add(post)
        copy = service.add(copy)
        service.dislikeById(1)

        val result = service.dislikeById(1)
        assertEquals(expected, result)

    }

    @Test
    fun updatePost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        val expected = Post (
            id = 1,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        service.add(post)
        val copy = post.copy(ownerId = 2, date = "18.12.2020" )
        service.add(copy)

        val isResult = service.update(expected)
        val result = service.get(expected.id)
        assertTrue(isResult && result.ownerId == copy.ownerId && result.date == copy.date)

    }


    @Test
    fun updatePostNotExistId() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        val expected = Post (
            id = 4,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = emptyArray<Attachment>()
        )

        service.add(post)
        val copy = post.copy(ownerId = 2, date = "18.12.2020" )
        service.add(copy)

        assertFalse(service.update(expected))

    }

    @Test
    fun displayPostWithoutAttachment() {
        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = null
        )
        viewPost(post)

    }

    @Test
    fun checkPostAttachment() {
        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = null
        )

        val expected = "No attachment"

        val result = getPostAttachment(post)
        assertEquals(expected, result)
    }

    @Test
    fun checkPostEmptyAttachmentNoteText() {
        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = null
        )

        val expected = "none"

        val result = post.attachments?.get(0)?.type ?: "none"
//            getPostAttachmentNoteText(post)
        assertEquals(expected, result)
    }

    @Test
    fun checkPostAttachmentLinkType() {
        val none = Attachment.NotAttachment
        val link = Attachment.Link(
            id = 3,
            ownerId = 0,
            url = "url_lonk",
            title = "Title Link 3",
            caption = "caption Link 3",
            description = "description Link 3",
            photo = null,
            product = null,
            button = null,
            previewPage = "preview",
            previewUrl = "url preview"
        )

        val graffiti = Attachment.Graffiti(
            id = 1,
            ownerIid = 4,
            photo130 = "130",
            photo604 = "604"
        )

        val page = Attachment.Page(
             id = 65,
             groupId = 34,
             title = "Title Page 65"
        )

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = arrayOf(link, graffiti, page)
        )
        val expected = "link"

        val attLink = post.attachments?.get(0)
        val attGraffiti = post.attachments?.get(1)
        val attPage = post.attachments?.get(2)


        val result = attachIs(post.attachments?.get(0) ?: none)
        assertEquals(expected, result)
    }

    @Test
    fun checkPostAttachmentPageType() {
        val none = Attachment.NotAttachment
        val link = Attachment.Link(
            id = 3,
            ownerId = 0,
            url = "url_lonk",
            title = "Title Link 3",
            caption = "caption Link 3",
            description = "description Link 3",
            photo = null,
            product = null,
            button = null,
            previewPage = "preview",
            previewUrl = "url preview"
        )

        val graffiti = Attachment.Graffiti(
            id = 1,
            ownerIid = 4,
            photo130 = "130",
            photo604 = "604"
        )

        val page = Attachment.Page(
            id = 65,
            groupId = 34,
            title = "Title Page 65"
        )
        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = arrayOf(link, graffiti, page)
        )
        val expected = "page"

        val attLink = post.attachments?.get(0)
        val attGraffiti = post.attachments?.get(1)
        val attPage = post.attachments?.get(2)

        val result = attachIs(post.attachments?.get(2) ?: none)
        assertEquals(expected, result)

    }

    @Test
    fun checkPostAttachmentNoneType() {
        val none = Attachment.NotAttachment
        val link = Attachment.Link(
            id = 3,
            ownerId = 0,
            url = "url_lonk",
            title = "Title Link 3",
            caption = "caption Link 3",
            description = "description Link 3",
            photo = null,
            product = null,
            button = null,
            previewPage = "preview",
            previewUrl = "url preview"
        )

        val graffiti = Attachment.Graffiti(
            id = 1,
            ownerIid = 4,
            photo130 = "130",
            photo604 = "604"
        )

        val page = Attachment.Page(
            id = 65,
            groupId = 34,
            title = "Title Page 65"
        )

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = arrayOf(link, graffiti, page, none)
        )
        val expected = ""

        val attLink = post.attachments?.get(0)
        val attGraffiti = post.attachments?.get(1)
        val attPage = post.attachments?.get(2)

        val result = attachIs(post.attachments?.get(3) ?: none)
        assertEquals(expected, result)
    }

    @Test
    fun checkPostAttachmentGraffitiType() {
        val none = Attachment.NotAttachment
        val link = Attachment.Link(
            id = 3,
            ownerId = 0,
            url = "url_lonk",
            title = "Title Link 3",
            caption = "caption Link 3",
            description = "description Link 3",
            photo = null,
            product = null,
            button = null,
            previewPage = "preview",
            previewUrl = "url preview"
        )

        val graffiti = Attachment.Graffiti(
            id = 1,
            ownerIid = 4,
            photo130 = "130",
            photo604 = "604"
        )

        val page = Attachment.Page(
            id = 65,
            groupId = 34,
            title = "Title Page 65"
        )
        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views(),
            attachments = arrayOf(link, graffiti, page)
        )
        val expected = "graffiti"

        val attLink = post.attachments?.get(0)
        val attGraffiti = post.attachments?.get(1)
        val attPage = post.attachments?.get(2)

        val result = attachIs(post.attachments?.get(1) ?: none)
        assertEquals(expected, result)

    }

}