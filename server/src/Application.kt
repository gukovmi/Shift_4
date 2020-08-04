package com.example.server

import com.example.server.repository.NotesRepository
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)


@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
        }
    }

    routing {
        get("/notes") {
            val repository = NotesRepository()
            val notesList= repository.getAll()
            call.respond(notesList)
        }

        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}

