package com.ha

import com.esotericsoftware.yamlbeans.YamlReader
import com.ha.config.YamlConfig
import com.ha.util.Constant
import com.ha.util.YamlUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.yaml.snakeyaml.Yaml
import java.io.File
import java.io.FileInputStream
import java.io.FileReader
import java.util.*


@SpringBootApplication
class Main: CommandLineRunner {
//    @Autowired
//    lateinit var config: YamlConfig

    override fun run(vararg args: String?) {
//        println(config.getData())

    }

    suspend fun f1(): Int {
        Thread.sleep(10000)
//        yaml.person
        return 1
    }


}

class Two {
    fun hello(args: Array<String>) {

        val url = javaClass.getResource(Constant.Yaml.APP.getFilename())
        val reader = YamlReader(FileReader(File(url.toURI())))
        val yaml = reader.read(YamlConfig::class.java)

        val app = SpringApplication(Main::class.java)
        app.setDefaultProperties(mapOf(Pair(yaml.server.port.key, yaml.server.port.value)))
        app.run(*args)
    }
}

fun  main(args: Array<String>) {
    val he = Two()
    he.hello(args)
}
