package com.example.common

import java.io.Serializable


class Note(
    val id:Long,
    val title:String,
    val description:String
): Serializable