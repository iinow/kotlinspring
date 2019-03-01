package com.ha.ex.service

import reactor.core.publisher.Mono
import com.ha.ex.request.Blog
import reactor.core.publisher.Flux
import com.ha.ex.repository.BlogRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service


@Service
class BlogServiceImpl : BlogService {

    @Autowired
    private val blogRepository: BlogRepository? = null

    override fun createBlog(blog: Blog): Mono<Blog> {
        var qry = Query()

        return blogRepository!!.insert(blog)
    }

    override fun findAll(): Flux<Blog> {
        return blogRepository!!.findAll()
    }

    override fun updateBlog(blog: Blog, id: String): Mono<Blog> {
        return findOne(id).doOnSuccess { findBlog ->
            findBlog.content = blog.content
            findBlog.title = blog.title
            findBlog.author = blog.author
            blogRepository!!.save(findBlog).subscribe()
        }
    }

    override fun findOne(id: String): Mono<Blog> {
        return blogRepository!!.findByIdAndDeleteIsFalse(id).switchIfEmpty(Mono.error(Exception("No Blog found with Id: $id")))
    }

    override fun findByTitle(title: String): Flux<Blog> {
        return blogRepository!!.findByAuthorAndDeleteIsFalse(title)
                .switchIfEmpty(Mono.error(Exception("No Blog found with title Containing : $title")))
    }

    override fun delete(id: String): Mono<Boolean> {
        return findOne(id).doOnSuccess { blog ->
            blog.delete = true
            blogRepository!!.save(blog).subscribe()
        }.flatMap { (title, content, author) -> Mono.just(java.lang.Boolean.TRUE) }
    }
}