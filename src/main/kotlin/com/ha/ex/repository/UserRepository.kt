package com.ha.ex.repository

import com.ha.ex.request.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/*
@Repository
interface UserRepository: ReactiveCrudRepository<User, String> {
    fun findAll(value: String): Flux<User>
    fun findFirst(owner: Mono<String>)
}*/
