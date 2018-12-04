package com.ha

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import java.util.*


@SpringBootApplication
class Main {
    /*fun start(vararg list : String) : Unit {
        SpringApplication.run(com.ha.Main::class.java, list)
    }*/
}

fun main(args: Array<String>) {
    val app = SpringApplication(Main::class.java)
    app.setDefaultProperties(Collections.singletonMap<String, Any>("server.port", "8071"))
    app.run(*args)
}
