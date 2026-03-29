package edu.eci.arep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Secure Web Application.
 *
 * @author Jesús Pinzón
 * @version 1.0
 * @since 2026-03-23
 */
@SpringBootApplication
public class SecureWebApplication {

    /**
     * Launches the Spring Boot application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SecureWebApplication.class, args);
    }
}