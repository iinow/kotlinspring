package com.ha.ex.repository

import com.ha.ex.request.Blog
import reactor.core.publisher.Mono
import reactor.core.publisher.Flux
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository


@Repository
interface BlogRepository : ReactiveMongoRepository<Blog, String> {
    fun findByAuthor(author: String): Flux<Blog>
    fun findByAuthorAndDeleteIsFalse(titleKeyword: String): Flux<Blog>
    fun findByTitle(title: String): Mono<Blog>
    fun findByIdAndDeleteIsFalse(id: String): Mono<Blog>
}