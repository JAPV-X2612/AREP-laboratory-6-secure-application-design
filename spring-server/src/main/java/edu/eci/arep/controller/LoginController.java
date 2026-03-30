package edu.eci.arep.controller;

import edu.eci.arep.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller that exposes the login endpoint.
 *
 * @author Jesús Pinzón
 * @version 1.0
 * @since 2026-03-23
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginService loginService;

    /**
     * Constructs the controller with its required service.
     *
     * @param loginService the login service
     */
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * Validates user credentials.
     *
     * @param username the submitted username
     * @param password the submitted password (plain text, hashed internally)
     * @return 200 OK with a success message, or 401 Unauthorized
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username,
                                        @RequestParam String password) {
        if (loginService.authenticate(username, password)) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}