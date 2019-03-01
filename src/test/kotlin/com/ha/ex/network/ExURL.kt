package com.ha.ex.network

import org.junit.Test
import org.springframework.test.annotation.DirtiesContext
import java.lang.invoke.MethodType
import java.net.URL

class ExURL{

    @Test
    fun getURL(){
        val url = URL("http://google.com")
        println("url : ${url}")

    }
}