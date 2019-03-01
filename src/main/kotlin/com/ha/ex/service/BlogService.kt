package com.ha.ex.service

import reactor.core.publisher.Mono
import com.ha.ex.request.Blog
import reactor.core.publisher.Flux


interface BlogService {
    fun createBlog(blog: Blog): Mono<Blog>
    fun updateBlog(blog: Blog, id: String): Mono<Blog>
    fun findAll(): Flux<Blog>
    fun findOne(id: String): Mono<Blog>
    fun findByTitle(title: String): Flux<Blog>
    fun delete(id: String): Mono<Boolean>
}