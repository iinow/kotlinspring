package com.ha.ex.request

import org.bson.BsonObjectId
import org.springframework.data.annotation.*
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.index.TextIndexed
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable
import java.util.*

@Document
data class User(@Id val id: BsonObjectId, val name: String, val age: Int)

abstract class BaseEntity: Serializable {
    @Id private lateinit var id: String
    @CreatedBy private lateinit var createdBy: String
    @CreatedDate private lateinit var createdDate: Date
    @LastModifiedBy private lateinit var updatedBy: String
    @LastModifiedDate private lateinit var updatedDate: Date
    @Version private var version: Long = 0
    var delete: Boolean = false
}

@Document(collection = "blog")
data class Blog(@TextIndexed var title: String, var content: String, @Indexed var author: String): BaseEntity()