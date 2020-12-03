package tech.threecrabs

import io.kotest.core.spec.style.FeatureSpec
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
        }
    }
}