package com.ha.ex.controller

import com.ha.ex.request.Blog
import reactor.core.publisher.Mono
import org.springframework.http.HttpStatus
import reactor.core.publisher.Flux
import com.ha.ex.service.BlogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.web.bind.annotation.*


//@EnableAsync
@RestController
@RequestMapping("/api/v1/blog")
class BlogController {
    @Autowired lateinit var mongoTemplate: ReactiveMongoTemplate

    @Autowired
    private val blogService: BlogService? = null

    @GetMapping
    fun findAll(): Flux<Blog> {
        return mongoTemplate.findAll(Blog::class.java)
//        return blogService!!.findAll()
    }

//    @Async("v")
    @GetMapping("/find")
    fun findByTitle(@RequestParam blogTitle: String): Flux<Blog> {
        return blogService!!.findByTitle(blogTitle)
    }

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: String): Mono<Blog> {
        return blogService!!.findOne(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody blog: Blog): Mono<Blog> {
        return blogService!!.createBlog(blog)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): Mono<Boolean> {
        return blogService!!.delete(id)
    }

    @PutMapping("/{id}")
    fun updateBlog(@RequestBody blog: Blog, @PathVariable id: String): Mono<Blog> {
        return blogService!!.updateBlog(blog, id)
    }
}