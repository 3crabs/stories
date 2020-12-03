package tech.threecrabs

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/stories")
class StoriesController {

    @Post
    fun addStory(@Body story: Story?): HttpResponse<Story> {
        return HttpResponse.created(Story("name"))
    }
}