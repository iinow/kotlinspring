package com.ha.ex.controller

import com.ha.ex.request.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/test")
class TestController{
    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    @Autowired
    private lateinit var reactiveMongoTemplate: ReactiveMongoTemplate

    @GetMapping("/test")
    fun getTest(): String = "테스트랑께"

    @PostMapping("/user")
    fun postUser(): Boolean {
//        val user = User("Lee ha", 24)
//        val per = Person()

//        mongoTemplate.insert(user, "users")
        return true
    }

    @GetMapping("/users")
    fun getUsers(): Any {
        //reactiveMongoTemplate.find
        return reactiveMongoTemplate.findAll(User::class.java, "users")
//        return mongoTemplate.findAll(User::class.java, "users")
    }
}