package com.ha.ex.http

import java.net.InetSocketAddress
import java.net.ServerSocket
import java.util.logging.Logger

class Redirector(val newSite: String, val port: Int){
    companion object {
        private val logger = Logger.getLogger(Redirector::class.java.simpleName)
    }

    fun start(){
        val server = ServerSocket()
        val addr = InetSocketAddress(this.port)
        server.bind(addr)


    }
}