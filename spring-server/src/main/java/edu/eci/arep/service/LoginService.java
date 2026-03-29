package edu.eci.arep.service;

import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Map;

/**
 * Service responsible for user authentication with hashed password storage.
 *
 * @author Jesús Pinzón
 * @version 1.0
 * @since 2026-03-23
 */
@Service
public class LoginService {

    private static final Map<String, String> USER_STORE = Map.of(
            "admin", hash("admin123")
    );

    /**
     * Authenticates a user by comparing the hashed submitted password
     * against the stored hash.
     *
     * @param username the username to look up
     * @param password the plain-text password to verify
     * @return true if credentials are valid, false otherwise
     */
    public boolean authenticate(String username, String password) {
        String storedHash = USER_STORE.get(username);
        return storedHash != null && storedHash.equals(hash(password));
    }

    /**
     * Computes the SHA-256 hash of a given input string.
     *
     * @param input the plain-text string to hash
     * @return the hexadecimal SHA-256 hash
     * @throws RuntimeException if SHA-256 algorithm is unavailable
     */
    private static String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return HexFormat.of().formatHex(md.digest(input.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 not available", e);
        }
    }
}