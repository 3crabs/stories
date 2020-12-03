package tech.threecrabs

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client

@Client("/stories")
interface StoriesClient {

    @Post
    fun addStory(story: Story): HttpResponse<Story>
}
