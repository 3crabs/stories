package tech.threecrabs

import io.kotest.core.spec.style.FeatureSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import javax.inject.Inject

@MicronautTest
class StoriesTest : FeatureSpec() {

    @Inject
    lateinit var storiesClient: StoriesClient

    private val addStory = Story("story number 1")

    init {
        feature("истории") {

            scenario("endpoint существует") {
                storiesClient.addStory(addStory).status() shouldBe HttpStatus.CREATED
            }
        }
    }
}