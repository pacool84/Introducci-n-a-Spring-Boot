# Platzi Day Application

Este es un proyecto de Spring Boot desarrollado como parte del curso de Introducción a Spring Boot de Platzi.

## Descripción

Esta aplicación es una API REST que proporciona servicios relacionados con películas y utiliza Spring Boot como framework principal.

## Requisitos Previos

- Java 17 o superior
- Gradle
- Docker (opcional, para contenedorización)

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── platzi/
│   │           └── day/
│   │               ├── HelloController.java
│   │               ├── PlatziDayApplication.java
│   │               ├── PlatziPlayAIService.java
│   │               └── persistence/
│   │                   └── entity/
│   │                       └── MovieEntity.java
│   └── resources/
│       ├── application.properties
│       ├── application-dev.properties
│       └── application-prod.properties
└── test/
    └── java/
        └── com/
            └── platzi/
                └── day/
                    └── PlatziDayApplicationTests.java
```

## Configuración

El proyecto utiliza diferentes perfiles de configuración:
- `application.properties`: Configuración general
- `application-dev.properties`: Configuración para desarrollo
- `application-prod.properties`: Configuración para producción

## Ejecución

### Usando Gradle

```bash
# Compilar el proyecto
./gradlew build

# Ejecutar la aplicación
./gradlew bootRun
```

### Usando Docker

```bash
# Construir la imagen
docker-compose build

# Ejecutar la aplicación
docker-compose up
```

## Testing

Para ejecutar las pruebas unitarias:

```bash
./gradlew test
```

## Endpoints disponibles

- `GET /hello`: Endpoint de prueba que devuelve un saludo
- Otros endpoints serán documentados según se desarrollen

## Contribución

Si deseas contribuir al proyecto:

1. Haz un Fork del repositorio
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`)
3. Realiza tus cambios y haz commit (`git commit -am 'Agrega nueva característica'`)
4. Push a la rama (`git push origin feature/nueva-caracteristica`)
5. Crea un Pull Request

## Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo LICENSE para más detalles.

## Autor

[Tu nombre]

---
Desarrollado con ❤️ en el curso de Platzi
