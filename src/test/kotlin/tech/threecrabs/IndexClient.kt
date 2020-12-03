package tech.threecrabs

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("/")
interface IndexClient {

    @Get
    fun index(): HttpResponse<String>
}
