package tech.threecrabs

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FeatureSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.security.authentication.UsernamePasswordCredentials
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import javax.inject.Inject

@MicronautTest
class StoriesTest : FeatureSpec() {

    @Inject
    private lateinit var storiesClient: StoriesClient

    @Inject
    private lateinit var storiesRepository: StoriesRepository

    @Inject
    private lateinit var appClient: AppClient

    private val addStory = Story(null, "story number 1")

    init {
        feature("истории") {

            scenario("endpoint на создание возвращает created") {
                val e = shouldThrow<HttpClientResponseException> { storiesClient.addStory(null, addStory) }
                e.status shouldBe HttpStatus.UNAUTHORIZED
            }

            scenario("история добавляется в базу") {
                storiesRepository.findAll().toList().size shouldBe 0
                val creds = UsernamePasswordCredentials("user", "password")
                val loginRsp = appClient.login(creds)
                storiesClient.addStory("Bearer ${loginRsp.accessToken}", addStory)
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