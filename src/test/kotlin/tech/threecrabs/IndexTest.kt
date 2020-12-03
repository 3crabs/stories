package tech.threecrabs

import io.kotest.core.spec.style.FeatureSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import javax.inject.Inject

@MicronautTest
class IndexTest : FeatureSpec() {

    @Inject
    lateinit var indexClient: IndexClient

    init {
        feature("главная страница") {

            scenario("существует") {
                indexClient.index().status shouldBe HttpStatus.OK
            }

            scenario("тело ответа не пустое") {
                indexClient.index().body().shouldNotBeNull()
            }

            scenario("есть ссылки документации") {
                forAll(
                    row("<a href='/swagger-ui/index.html'>swagger-ui</a>"),
                    row("<a href='/redoc/index.html'>redoc</a>"),
                    row("<a href='/rapidoc/index.html'>rapidoc</a>")
                ) { link ->
                    indexClient.index().body()!!.contains(link).shouldBeTrue()
                }
            }
        }
    }
}