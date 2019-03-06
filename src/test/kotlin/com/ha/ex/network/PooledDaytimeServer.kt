package com.ha.ex.network

import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.Callable
import java.util.concurrent.Executors

class PooledDaytimeServer{
    companion object {
        val PORT = 13

        internal class DaytimeTask : Callable<Void> {

            @Throws(Exception::class)
            override fun call(): Void? {
                return null
            }
        }
    }
}

fun main(args: Array<String>) {
    val pool = Executors.newFixedThreadPool(50)
    try {
        val server = ServerSocket(PooledDaytimeServer.PORT)
        while(true){
            try {
                val connection = server.accept()
                val task = MultithreadedDaytimeServer.Companion.DaytimeThread(connection)
                pool.submit(task)
            }catch (e: Exception){
                println(e)
            }
        }
    }catch (e: Exception){
        println(e)
    }
}