package com.example.common

import java.io.Serializable

class Note(
    val id:Long,
    var title:String,
    var description:String
): Serializable