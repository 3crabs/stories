package tech.threecrabs

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "Истории")
@Controller("/stories")
class StoriesController {

    @Operation(summary = "Создание новой истории")
    @Post
    fun addStory(@Body story: Story?): HttpResponse<Story> {
        return HttpResponse.created(Story("name"))
    }
}