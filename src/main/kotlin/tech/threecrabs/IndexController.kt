package tech.threecrabs

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.views.ModelAndView
import io.micronaut.views.View

@Controller("/")
class IndexController {

    @Get(processes = [MediaType.TEXT_HTML])
    @View("index")
    fun index(): ModelAndView<String> {
        return ModelAndView("index", null)
    }
}