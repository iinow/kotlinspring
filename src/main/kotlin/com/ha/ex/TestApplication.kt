package com.ha.ex

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class TestApplication

fun main(args: Array<String>) {
//    val app = SpringApplication(TestApplication::class.java)
//    app.run(*args)

    A().ma()
}

class A{
    fun ma(){
        val url = A::class.java.getResource("/Hi.properties")

        println(url.path)
    }
}