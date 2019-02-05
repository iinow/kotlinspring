package com.ha.util

object Constant {
    enum class Yaml(val index: Int){
        Hi(1) {
            override fun getFilename() = "/Hi.yaml"
        },
        APP(2){
            override fun getFilename() = "/application2.yaml"
        };

        abstract fun getFilename(): String
    }

    enum class Properties(val index: Int){
        Hi(1) {
            override fun getFilename() = "Hi.properties"
        };

        abstract fun getFilename(): String
    }
}