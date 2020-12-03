package tech.threecrabs

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("/")
interface SwaggerClient {

    @Get(value = "/swagger-ui/index.html", processes = [MediaType.TEXT_HTML])
    fun getSwaggerUi(): HttpResponse<String>

    @Get(value = "/redoc/index.html", processes = [MediaType.TEXT_HTML])
    fun getRedoc(): HttpResponse<String>

    @Get(value = "/rapidoc/index.html", processes = [MediaType.TEXT_HTML])
    fun getRapidoc(): HttpResponse<String>
}
