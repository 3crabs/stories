package tech.threecrabs

import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.AuthenticationProvider
import io.micronaut.security.authentication.AuthenticationRequest
import io.micronaut.security.authentication.AuthenticationResponse
import io.micronaut.security.authentication.UserDetails
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import org.reactivestreams.Publisher
import javax.inject.Singleton


@Singleton
class CustomAuthenticationProvider : AuthenticationProvider {

    override fun authenticate(
        httpRequest: HttpRequest<*>?,
        authenticationRequest: AuthenticationRequest<*, *>?
    ): Publisher<AuthenticationResponse> {
        return Flowable.create({
            it.onNext(UserDetails("", listOf("USER")))
            it.onComplete()
        }, BackpressureStrategy.ERROR)
    }
}