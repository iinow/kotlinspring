package com.ha.ex.network

import java.io.OutputStreamWriter
import java.lang.Exception
import java.net.ServerSocket
import java.net.Socket
import java.util.*

class MultithreadedDaytimeServer{
    companion object {
        val PORT = 13

        class DaytimeThread(val connection: Socket): Thread(){
            override fun run() {
                try {
                    val out = OutputStreamWriter(connection.getOutputStream())
                    val now = Date()
                    out.write(now.toString() + "\r\n")
                    out.flush()
                }catch (e: Exception){
                    println(e)
                }finally {
                    try {
                        connection.close()
                    }catch (e: Exception){

                    }
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    try {
        val server = ServerSocket(MultithreadedDaytimeServer.PORT)
        while(true){
            try {
                val connection = server.accept()
                val task = MultithreadedDaytimeServer.Companion.DaytimeThread(connection)
                task.start()
            }catch (e: Exception){

            }
        }
    }catch (e: Exception){

    }
}