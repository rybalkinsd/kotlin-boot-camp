package io.rybalkinsd.kotlinbootcamp.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("example")
class ExampleController {
    @Autowired
    lateinit var beanRegistry: BeanRegistryService

    @RequestMapping("bean")
    @ResponseBody
    fun exampleBean(@Autowired exampleBean: PrototypeBean) = exampleBean

    @RequestMapping("registry")
    @ResponseBody
    fun beanRegistry() = beanRegistry
}
