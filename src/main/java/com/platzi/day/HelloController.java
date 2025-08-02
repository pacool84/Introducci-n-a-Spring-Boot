package com.platzi.day;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Indica que es un controlador de peticiones
public class HelloController {
    @GetMapping("/") //Indica que responde a peticiones GET en la ruta /
    public String hello() {
        return "Hello my friend Spring Boot!";
    }
}
