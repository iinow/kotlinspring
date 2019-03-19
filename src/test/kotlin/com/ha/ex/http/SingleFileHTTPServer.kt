package com.ha.ex.http

import java.io.*
import java.net.*
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.logging.Level
import java.util.logging.Logger

class SingleFileHTTPServer {
    companion object {
        private val logger = Logger.getLogger(SingleFileHTTPServer::class.java.simpleName)
    }
    private lateinit var content: ByteArray
    private lateinit var header: ByteArray
    private var port = 0
    private lateinit var encoding: String

    constructor(data: String, encoding: String, mimeType: String, port: Int): this(data.toByteArray(charset(encoding)), encoding, mimeType, port)
    constructor(data: ByteArray, encoding: String, mimeType: String, port: Int){
        this.content = data
        this.port = port
        this.encoding = encoding
        val header = "HTTP/1.0 200 OK\r\n" +
                "Server: OneFile 2.0\r\n" +
                "Content-length: ${this.content.size} \r\n" +
                "Content-type: $mimeType" + "; charset=$encoding\r\n\r\n"
        this.header = header.toByteArray(Charset.forName("UTF-8"))
    }

    fun start(){
        var pool = Executors.newFixedThreadPool(100)
        val server = ServerSocket()
        try {
            val addr = InetSocketAddress(this.port)
            server.bind(addr)

            logger.info("Accepting connections on port ${server.localPort}")
            logger.info("Data to be sent:")
            logger.info(String(this.content, charset(this.encoding)))

            while(true){
                try {
                    val connection = server.accept()
                    pool.submit(HTTPHandler(connection, header, content)).get()
                }catch (e: Exception){

                }
            }
        }catch (e: Exception){

        }
    }

    private class HTTPHandler(val connection: Socket, val header: ByteArray, val content: ByteArray): Callable<Void> {
        override fun call(): Void? {
            try {
                var out = BufferedOutputStream(connection.getOutputStream())
                var inp = BufferedInputStream(connection.getInputStream())

                var request = StringBuilder(80)
                while(true){
                    val c = inp.read()
                    if (c == '\r'.toInt() || c == '\n'.toInt() || c == -1) {
                        break
                    }
                    request.append(c.toChar())
                }

                if(request.toString().indexOf("HTTP/") != -1){
                    out.write(header)
                }
                out.write(content)
                out.flush()

            }catch (e: Exception){
                logger.log(Level.WARNING, "Error wrting to client", e)
            }finally {
                connection.close()
            }
            return null
        }
    }
}

fun main(args: Array<String>) {
    val port = 2383
    try {

    }catch (e: Exception){

    }

    val encoding = "UTF-8"
    val content = "아하옿아황화오하옿이"
    val filepath = "D:\\hello.txt"
    val path = Paths.get(filepath)
    val data = Files.readAllBytes(path)
    val filename = "hello.txt"
    val contentType = URLConnection.getFileNameMap().getContentTypeFor(filename)
    val server = SingleFileHTTPServer(data, encoding, contentType, port)
    server.start()
}