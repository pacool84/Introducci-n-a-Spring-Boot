package com.platzi.day.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService// Anotación que indica que es un servicio de IA
public interface PlatziPlayAIService {

    @UserMessage("""
            Genera una saludo de bienvenida a la plataforma de Gestion de Peliculas {{platform}}.
            Usa menos de 120 caracteres hazlo con el estilo de Platzi.
            """)
    String generateGreeting(@V("platform") String platform); // Método que genera un saludo de bienvenida para la plataforma

    @SystemMessage("""
            Eres un experto en cines que recomienda peliculas personalizadas segun los gustos del usuario.
            Debes recomendar maximo 3 peliculas.
            No incluyas peliculas que esten por fuera de la plataforma de Platzi Play.
            """)
    String generateMovieSuggestion(@UserMessage String userMessage); // Método que genera una sugerencia de película basada en el mensaje del usuario

}
// Esta interfaz define un servicio de IA que genera un saludo de bienvenida
// para la plataforma de gestión de películas Platzi Play.
