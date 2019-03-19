package com.ha.ex.network

import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.Callable
import java.util.logging.Logger

class LoggingDaytimeServer{
    companion object {
        val PORT = 13
        val auditLogger = Logger.getLogger("requests")
        val errorLogger = Logger.getLogger("errors")

        class DaytimeTask: Callable<Void>{
            lateinit var connection: Socket
            constructor(connection: Socket){
                this.connection = connection
            }

            override fun call(): Void? {
                return null
            }
        }
    }
}

fun main(args: Array<String>) {
//    val dd = LoggingDaytimeServer.Companion.DaytimeTask()
    val server = ServerSocket()
}