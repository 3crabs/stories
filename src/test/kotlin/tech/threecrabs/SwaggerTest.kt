package tech.threecrabs

import io.kotest.core.spec.style.FeatureSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import javax.inject.Inject

@MicronautTest
class SwaggerTest : FeatureSpec() {

    @Inject
    lateinit var swaggerClient: SwaggerClient

    init {
        feature("документация") {

            scenario("ссылки документации активны") {
                swaggerClient.getSwaggerUi().status shouldBe HttpStatus.OK
                swaggerClient.getRedoc().status shouldBe HttpStatus.OK
                swaggerClient.getRapidoc().status shouldBe HttpStatus.OK
            }
        }
    }
}