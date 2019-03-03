package com.ha.ex

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.servlet.server.Session
import org.springframework.test.context.junit4.SpringRunner
import java.io.*
import java.net.*
import javax.servlet.http.Cookie

//@RunWith(SpringRunner::class)
//@SpringBootTest
class ExApplicationTests {

    @Test
    fun contextLoads() {
        val cookie1 = Cookie("name", "ddd")
        val cookie2 = Session.Cookie()
        cookie1.maxAge = 2

        println("cookie name: ${cookie1.name}, value: ${cookie1.value}")

        val manager = CookieManager()
        CookieHandler.setDefault(manager)
        manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL)
        manager.setCookiePolicy { uri, cookie -> !(uri.authority.toLowerCase().endsWith(".gov") || cookie.domain.toLowerCase().endsWith(".gov")) }

        val store = manager.cookieStore


    }

    @Test
    fun URI() {
        val url = URL("https://www.kpx.or.kr/www/contents.do?key=225")
        val connect: URLConnection = url.openConnection()

        println("content type: ${connect.contentType}")
        println("content length: ${connect.contentLength}")
        println("content length long: ${connect.contentLengthLong}")

        val input = BufferedInputStream(connect.getInputStream())
        val reader = InputStreamReader(input, "UTF-8")
        /*var c: Int = 0
        c = reader.read()
        while((c=reader.read())!=-1){

        }*/

        println("${connect.contentEncoding}")
        println("date : ${connect.date}")
        println("expiration : ${connect.expiration}")
    }

    @Test
    fun cookieWait() {
        val cookie = Cookie("name", "haaha")
        cookie.maxAge = 5

        Thread.sleep(6000)

        println("cookie : ${cookie.name}, ${cookie.value}")
    }

    @Test
    fun header() {
        val url = URL("https://www.kpx.or.kr/www/contents.do?key=225")
        val connect: URLConnection = url.openConnection()
//		println(connect.headerFields)
        val iter = connect.headerFields.keys.iterator()
        for (str in iter) {
            connect.headerFields.get(str)!!.forEach { println("key : $str, array value : $it") }
        }
    }

    @Test
    fun socket() {
        /*val sock = Socket("dict.org", 2628)
        sock.soTimeout = 15000

        val outputSteam = sock.getOutputStream()
        val writer = OutputStreamWriter(outputSteam, "UTF-8")
        writer.write("DEFINE eng-lat gold\r\n")
        writer.flush()

        val input = sock.getInputStream()
        val buffer = BufferedReader(InputStreamReader(input, "UTF-8"))
        for(str in buffer.readLine()){
            println(str)
        }*/
//		sock.close()

        try {
            val so = Socket("www.oreilly.com", 80)
        } catch (ex: UnknownHostException) {
            println(ex)
        } catch (ex: IOException) {
            println(ex)
        }
        val ip = Inet4Address.getLocalHost()
        val list = listOf(22, 3389)
        for(port in list){
            try {
                val sock = Socket(ip.hostName, port)
                println("There is a server on port $port of ${ip.hostAddress}")
            }catch (e: Exception){
                println(e)
                println("There's not a server on port $port of ${ip.hostAddress}")
            }
        }
    }
}

