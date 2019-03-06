package com.ha.ex.network.echo

import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.SelectionKey
import java.nio.channels.Selector
import java.nio.channels.ServerSocketChannel
import java.nio.channels.SocketChannel

class EchoServer{
    companion object {
        var DEFAULT_PORT = 7
    }

    fun start(port: Int?){
        port ?: DEFAULT_PORT

        println("Listening for connections on port $port")

        var serverChannel: ServerSocketChannel
        var selector: Selector
        try {
            serverChannel = ServerSocketChannel.open()
            val ss = serverChannel.socket()
            val addr = InetSocketAddress(port!!)
            ss.bind(addr)
            serverChannel.configureBlocking(false)
            selector = Selector.open()
            serverChannel.register(selector, SelectionKey.OP_ACCEPT)
        }catch (e: Exception){
            println(e)
            return
        }

        while(true){
            try {
                selector.select()
            }catch (e: Exception){
                break
            }

            var readyKeys = selector.selectedKeys()
            var iterator = readyKeys.iterator()
            while(iterator.hasNext()){
                var key = iterator.next()
                iterator.remove()
                try {
                    if(key.isAcceptable){
                        val server = key.channel() as ServerSocketChannel
                        val client = server.accept()
                        println("Accepted connection from $client")
                        client.configureBlocking(false)
                        val clientKey = client.register(selector, SelectionKey.OP_WRITE or SelectionKey.OP_READ)//()
                        var buffer = ByteBuffer.allocate(100)
                        clientKey.attach(buffer)
                    }

                    if(key.isReadable){
                        val client = key.channel() as  SocketChannel
                        val output = key.attachment() as ByteBuffer
                        client.read(output)
                    }

                    if(key.isWritable){
                        val client = key.channel() as  SocketChannel
                        val output = key.attachment() as ByteBuffer
                        output.flip()
                        client.write(output)
                        output.compact()
                    }
                }catch (e: Exception){
                    key.cancel()
                    try {
                        key.channel().close()
                    }catch (e: Exception){

                    }
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    EchoServer().start(232)
}