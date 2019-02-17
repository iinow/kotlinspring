package com.ha.ex

import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

class ExApplication: SpringBootServletInitializer(){
	override fun configure(builder: SpringApplicationBuilder?): SpringApplicationBuilder {
		return builder!!.sources(TestApplication::class.java)
	}
}
