package tech.threecrabs

import io.kotest.core.spec.style.FeatureSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import javax.inject.Inject

@MicronautTest
class StoriesTest : FeatureSpec() {

    @Inject
    private lateinit var storiesClient: StoriesClient

    @Inject
    private lateinit var storiesRepository: StoriesRepository

    private val addStory = Story(null, "story number 1")

    init {
        feature("истории") {

            scenario("endpoint на создание возвращает created") {
                storiesClient.addStory(addStory).status() shouldBe HttpStatus.CREATED
            }

            scenario("история добавляется в базу") {
                storiesRepository.findAll().toList().size shouldBe 0
                storiesClient.addStory(addStory)
                storiesRepository.findAll().toList().size shouldBe 1
            }
        }
    }

    override fun beforeTest(testCase: TestCase) {
        storiesRepository.deleteAll()
    }

    override fun afterTest(testCase: TestCase, result: TestResult) {
        storiesRepository.deleteAll()
    }
}