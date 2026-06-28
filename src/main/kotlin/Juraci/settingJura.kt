package com.devJura_ktor.Juraci

import io.ktor.resources.Resource
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.resources.Resources
import io.ktor.server.resources.delete
import io.ktor.server.resources.get
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.configureJuraci() {

    install(Resources)

    routing {
        get("/test") {
            call.respondText("A função do Juraci pegou!!")
        }

        get<Juraci> { juraci ->

            val testString = juraci.testApp
            call.respondText("Eu sou $testString")
        }

        delete<Juraci.Jesus> {JJ ->
            call.respondText("Ele é ${JJ.parent.testApp} e nasceu no ano de ${JJ.id}, usuário excluido com sucesso!")
        }

//        delete<Juraci> {
//            Junior -> call.respondText("Deletado com sucesso: ${Junior.testApp}")
//        }


    }
}

@Resource("/juraci")
class Juraci(val testApp: String? = "Dev Android em Kotlin") {
    @Resource("/oi")
    data class Jesus(val parent: Juraci, val id: Int = 2004)
}