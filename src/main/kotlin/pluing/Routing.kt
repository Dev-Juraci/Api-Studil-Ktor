package com.devJura_ktor.pluing

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

//    install(RoutingRoot) {
////        route(
////            "/", HttpMethod.Get
////        ) {
////            handle {
////                call.respondText("Juraci Junior!")
////            }
////        }
//    }

    routing {

        get("/ktorAndroid ") {
            val id = call.parameters["id"]

            if (HttpStatusCode.BadRequest.value == 400) {
                call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
            }

            call.respondText("Hello: ${id}", status = HttpStatusCode.OK)
        }

        get(Regex("lukel/certificado")) {
            val modelCerticado = call.queryParameters["valor"]

            if (modelCerticado == "A1") {

                val valueCertificate1 = mapOf(
                    "E-CNPJ A1 " to "R$ 209,00",
                    "E-CPF A1 " to "R$ 150,00",
                )

                call.respond(valueCertificate1)
            } else if (modelCerticado == "A3") {

                val valueCertificate3 = mapOf(
                    "E-CNPJ A3 de 1 ano" to "R$ 209,00",
                    "E-CNPJ A3 de 2 anos" to "R$ 250,00",
                    "E-CPF A3 de 1 anos" to "R$ 150,00",
                    "E-CPF A3 de 2 anos" to "R$ 200,00"
                )

                call.respond(valueCertificate3)

            } else {

                call.respondText("Not Found", status = HttpStatusCode.NotFound)

            }

        }


    }
}