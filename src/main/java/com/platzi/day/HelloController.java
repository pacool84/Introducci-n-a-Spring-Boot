package com.platzi.day;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Indica que es un controlador de peticiones
public class HelloController {
    private final PlatziPlayAIService aiService;
    // Constructor que inyecta el servicio de IA
    public HelloController(PlatziPlayAIService aiService) {
        this.aiService = aiService;
    }

    // Método que maneja las peticiones GET a la ruta /
    @GetMapping("/") //Indica que responde a peticiones GET en la ruta /
    public String hello() {
        return this.aiService.generateGreeting(); // Llama al servicio de IA para generar un saludo
    }
}
