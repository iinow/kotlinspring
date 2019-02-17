package com.ha.ex

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class ExController{
    @Autowired
    lateinit var mongoTemplate: MongoTemplate

    @GetMapping("test")
    fun getString(): String = "Hi"
}