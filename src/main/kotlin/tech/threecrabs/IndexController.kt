package tech.threecrabs

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.micronaut.views.ModelAndView
import io.micronaut.views.View
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "Главная страница")
@Controller("/")
@Secured(SecurityRule.IS_ANONYMOUS)
class IndexController {

    @Get(processes = [MediaType.TEXT_HTML])
    @View("index")
    fun index(): HttpResponse<ModelAndView<String>> {
        return HttpResponse.ok(ModelAndView("index", null))
    }
}