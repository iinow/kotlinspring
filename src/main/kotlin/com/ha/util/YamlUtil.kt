package com.ha.util

import com.esotericsoftware.yamlbeans.YamlReader
import java.io.File
import java.io.FileReader

object YamlUtil {
    const val dd: String = ""

    init {
        //
    }

    fun <T> getReadObject(filename: Constant.Yaml, classTemplate: Class<T>): T{
        var url = javaClass.getResource(filename.getFilename())
        val reader = YamlReader(FileReader(File(url.toURI())))
        return reader.read(classTemplate)
    }
}