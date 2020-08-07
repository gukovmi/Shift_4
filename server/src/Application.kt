package com.example.server

import com.example.common.CreateNoteDto
import com.example.common.Note
import com.example.server.db.DatabaseFactory
import com.example.server.repository.NotesRepository
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*
import java.net.URI

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)


@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            serializeNulls()
        }
    }

    val dbUri = URI(environment.config.property("db.jdbcUrl").getString())

    val username: String = dbUri.userInfo.split(":")[0]
    val password: String = dbUri.userInfo.split(":")[1]
    val dbUrl = ("jdbc:postgresql://${dbUri.host}:${dbUri.port}${dbUri.path}")

    DatabaseFactory(
        dbUrl = dbUrl,
        dbPassword = password,
        dbUser = username
    ).apply {
        init()
    }

    val repository = NotesRepository()

    routing {
        route("/notes") {
            get {

                val notesList = repository.getAll()
                call.respond(notesList)
            }
            post {
                val note = call.receive<CreateNoteDto>()
                repository.add(note)
                call.respond(HttpStatusCode.OK)
            }
            delete {
                val id = call.request.queryParameters["id"]?.toLong()
                if (id == null) {
                    call.respond(HttpStatusCode.NotFound)
                } else {
                    repository.delete(id)
                    call.respond(HttpStatusCode.OK)
                }
            }
            put {
                val note = call.receive<Note>()
                repository.update(note)
                call.respond(HttpStatusCode.OK)
            }


        }
    }
}


