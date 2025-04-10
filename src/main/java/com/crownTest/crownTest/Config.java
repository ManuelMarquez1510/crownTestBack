package com.crownTest.crownTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;

@Configuration
public class Config {

//CORS
    @Bean
    public WebMvcConfigurer corsConfigurer() { 

        System.out.println("CORS_ALLOWED_ORIGIN: ");
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Permite CORS en todas las rutas bajo /api
                        .allowedOriginPatterns("*")
                        // .allowedOrigins(("*")) // Permite solicitudes desde localhost:3000
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                        .allowedHeaders("*") // Headers permitidos
                        .allowCredentials(true); // Permite credenciales (cookies, headers de autenticación)
            }
        };
    }
}