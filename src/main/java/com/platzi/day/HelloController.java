package com.platzi.day;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Indica que es un controlador de peticiones
public class HelloController {
    private final String platform;
    private final PlatziPlayAIService aiService;

    // Constructor que inyecta el servicio de IA
    public HelloController(@Value("${spring.application.name}") String platform, PlatziPlayAIService aiService) {
        this.platform = platform;
        this.aiService = aiService;
    }

    // Método que maneja las peticiones GET a la ruta /
    @GetMapping("/") //Indica que responde a peticiones GET en la ruta /
    public String hello() {
        return this.aiService.generateGreeting(platform); // Llama al servicio de IA para generar un saludo
    }
}
