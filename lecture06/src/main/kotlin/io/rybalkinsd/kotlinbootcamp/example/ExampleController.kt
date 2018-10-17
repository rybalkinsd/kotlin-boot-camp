package io.rybalkinsd.kotlinbootcamp.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/example")
class ExampleController {
    @Autowired
    lateinit var beanRegistry: BeanRegistryService

    @Autowired
    lateinit var prototypeBean: PrototypeBean

    @Autowired
    lateinit var requestBean: RequestBean

    @Autowired
    lateinit var singletonBean: SingletonBean

    @RequestMapping("/prototypeBean")
    @ResponseBody
    fun prototypeBean() = prototypeBean.toString()

    @RequestMapping("/requestBean")
    @ResponseBody
    fun requestBean() = requestBean.toString()

    @RequestMapping("/singletonBean")
    @ResponseBody
    fun singletonBean() = singletonBean.toString()

    @RequestMapping("/registry")
    @ResponseBody
    fun beanRegistry() = beanRegistry.size()
}
