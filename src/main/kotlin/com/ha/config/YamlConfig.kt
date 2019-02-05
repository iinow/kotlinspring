package com.ha.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources
import org.springframework.stereotype.Component

//@Configuration
//@PropertySource(value = ["application2.yaml"])
/*@EnableConfigurationProperties
@ConfigurationProperties
@Component*/
class YamlConfig {

    lateinit var person: Array<String>
    lateinit var name: String
    lateinit var server: Server

    companion object {
        class Server{
            lateinit var ports: Array<Port>
        }
        class Port{
            var key:String = ""
            var value: String = ""
        }
    }
    fun getData(): String = "${person.toList()}, $name,"// port : ${server.port.key}, ${server.port.value}

    fun getConfigurationInfo(): Map<String, String> = this.server.ports.map { Pair(it.key, it.value) }.toMap()
}