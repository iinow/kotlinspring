package com.ha.ex.network

import org.junit.Test
import org.springframework.test.annotation.DirtiesContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.invoke.MethodType
import java.net.URL
import java.util.*

class ExURL{

    @Test
    fun getURL(){
        val url = URL("http://google.com")
        println("url : ${url}")
        val reader = BufferedReader(InputStreamReader(url.openConnection().getInputStream()))
        reader.lines().forEach { println(it) }

//        var timer = Timer("start")

//        val task = TimerTask()
//
//        timer.schedule
    }

    class Task2: TimerTask() {
        override fun run() {
            println("Hello world")
        }
    }
}