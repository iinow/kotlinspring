package com.ha.ex

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@EnableMongoAuditing
@EnableReactiveMongoRepositories
@SpringBootApplication
class ExApplication

fun main(args: Array<String>) {
//	runApplication<ExApplication>(*args)
    val app = SpringApplication(ExApplication::class.java)
    app.run(*args)
}

class A{
	fun df(){
//		URL url = Main.class.getClassLoader().getResource("/application.properties");
////        URL url = getClass().getResource("/application.properties");
		val url = javaClass.getResource("/application.properties")
//		var url = A::class.java.classLoader.getResource("")
		println(url.toString())
	}
}