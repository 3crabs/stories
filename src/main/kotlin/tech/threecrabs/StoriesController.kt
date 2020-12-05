package tech.threecrabs

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import javax.inject.Inject

@Tag(name = "Истории")
@Controller("/stories")
class StoriesController {

    @Inject
    private lateinit var storiesRepository: StoriesRepository

    @Operation(summary = "Создание новой истории")
    @Post
    fun addStory(@Body story: Story?): HttpResponse<Story> {
        return if (story != null) {
            HttpResponse.created(storiesRepository.save(story))
        } else {
            HttpResponse.badRequest()
        }
    }
}