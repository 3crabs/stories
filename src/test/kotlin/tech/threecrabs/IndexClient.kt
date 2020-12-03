package tech.threecrabs

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.views.ModelAndView

@Client("/")
interface IndexClient {

    @Get(processes = [MediaType.TEXT_HTML])
    fun index(): HttpResponse<ModelAndView<String>>
}
