package com.ha

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController{

    @RequestMapping(value= ["/gg"], method = [RequestMethod.PUT])
    fun hello() : String = "hello fff"
}