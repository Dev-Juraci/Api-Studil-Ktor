package com.devJura_ktor.Juraci

import io.ktor.resources.Resource
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.resources.Resources
import io.ktor.server.resources.get
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import io.ktor.server.routing.routing


fun Application.configureJuraci() {
    install(Resources)

    routing {

        get(Regex(".+/test")){
            call.respondText("Prazer em vê-lo aqui, aproveite bastante o sistema.")
        }


        get<InformationResource.Dates> { infDates ->

            val caetana = mapOf(
                "Titulo_do_Dia: " to infDates.autor.information,
                "Data_da_Publicação: " to infDates.autor.datesString,
                "Horário_da_Publicação: " to infDates.hour
            )
            call.respond(caetana)
        }

        get(Regex("versaoApp/v[1-2]")) {

            val id = call.queryParameters["v1"]!!


            if (id == "Android") {
                return@get call.respondText("Versão do Android é: 1.08.44")
            } else if (id == "Iphone") {
                return@get call.respondText("Versão do IPhone é: 0.87.96")
            }

            return@get call.respond("Versão de Destokp/Notebook é: 2.45.78")


        }

        route("/acount") {
            get("/criarConta") {
                call.respondText("Olá, precisa criar uma conta para dar andamento")
            }

            get("/login") {
                call.respondText("Login a sua conta!!")
            }

            get("/recuperarSenha") {
                call.respondText("Entre em contato com responsável.")
            }


        }
    }
}

@Resource("/informations")
class InformationResource(
    val information: String? = "Corinthians é campeão da SuperCopa de 2026",
    val datesString: String? = "30/06/2026"
) {

    @Resource("/dates")
    data class Dates(val hour: String = "15:45:19", val autor: InformationResource)

}