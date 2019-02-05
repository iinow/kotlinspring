package com.ha.model

interface Human{

}

data class Person(val name:String)

//data class Student(val age: Int):Person("")

fun test() {
    val ha = Person("ha")
    ha.copy(name="dfd")

    var tree : Pair<String, String>
}