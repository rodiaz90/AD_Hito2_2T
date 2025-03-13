package com.empleo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Indica que esta clase es la clase principal de la aplicación Spring Boot.
public class EmpleoApplication {
	
	// Método principal (entry point) que se ejecuta cuando se inicia la aplicación.
	public static void main(String[] args) {
		
		SpringApplication.run(EmpleoApplication.class, args);
		
        // Inicia la aplicación Spring Boot. Esta línea:
        // - Configura el contexto de aplicación (ApplicationContext).
        // - Escanea los componentes (@Component, @Service, @Repository, @Controller, etc.).
        // - Configura beans y sus dependencias según la configuración definida.
        // - Levanta el servidor integrado (Tomcat, en este caso).
		
	}
}
