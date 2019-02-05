package com.ha

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController{
//    @Autowired
//    private lateinit var yaml: YamlConfig

    @RequestMapping(value= ["/gg"], method = [RequestMethod.PUT])
    fun hello() : String = "hello fff"

    @RequestMapping(value= ["/gg2"], method = [RequestMethod.GET])
    fun hello2() : String = "sss"
}
