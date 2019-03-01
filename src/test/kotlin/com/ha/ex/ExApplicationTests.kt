package com.ha.ex

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.servlet.server.Session
import org.springframework.test.context.junit4.SpringRunner
import java.io.BufferedInputStream
import java.io.InputStreamReader
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
	fun URI(){
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
	fun cookieWait(){
		val cookie = Cookie("name", "haaha")
		cookie.maxAge = 5

		Thread.sleep(6000)

		println("cookie : ${cookie.name}, ${cookie.value}")
	}

	@Test
	fun header(){
		val url = URL("https://www.kpx.or.kr/www/contents.do?key=225")
		val connect: URLConnection = url.openConnection()
//		println(connect.headerFields)
		val iter = connect.headerFields.keys.iterator()
		for(str in iter){
			connect.headerFields.get(str)!!.forEach { println("key : $str, array value : $it") }
		}
	}

	@Test
	fun header2(){
		val url = URL("http://ems.wooam.com")//ice/v1/users/em18/login
		val connect: URLConnection = url.openConnection()
		val iter = connect.headerFields.keys.iterator()
		for(str in iter){
			connect.headerFields.get(str)!!.forEach { println("key : $str, array value : $it") }
		}
	}
}

