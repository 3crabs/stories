package tech.threecrabs

import io.kotest.core.spec.style.FeatureSpec
import io.kotest.matchers.nulls.shouldBeNull
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
                indexClient.index().body().shouldBeNull()
            }

            scenario("есть ссылка на swagger документацию") {
                indexClient.index().body()!!.contains("<a href='/swagger-ui/index.html'>swagger-ui</a>") shouldBe true
            }

            scenario("есть ссылка на redoc документацию") {
                indexClient.index().body()!!.contains("<a href='/redoc/index.html'>swagger-ui</a>") shouldBe true
            }

            scenario("есть ссылка на rapidoc документацию") {
                indexClient.index().body()!!.contains("<a href='/rapidoc/index.html'>swagger-ui</a>") shouldBe true
            }
        }
    }
}
