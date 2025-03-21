package dev.anurag.HotelApp.controller;

import dev.anurag.HotelApp.entity.User;
import dev.anurag.HotelApp.security.AuthRequest;
import dev.anurag.HotelApp.security.JWTUtil;
import dev.anurag.HotelApp.service.UserService;
import dev.anurag.HotelApp.security.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JWTUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        Optional<User> user = userService.findByUsername(authRequest.getUsername());
        if (user.isPresent() && passwordEncoder.matches(authRequest.getPassword(), user.get().getPassword())) {
            String token = jwtUtil.generateToken(user.get());
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @PostMapping("/admin-login")
    public ResponseEntity<?> adminLogin(@RequestBody AuthRequest authRequest) {
        Optional<User> admin = userService.findByUsername(authRequest.getUsername());
        if (admin.isPresent() && passwordEncoder.matches(authRequest.getPassword(), admin.get().getPassword())) {
            if (!"ADMIN".equals(admin.get().getRole())) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Denied: Not an Admin");
            }
            String token = jwtUtil.generateToken(admin.get());
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Admin credentials");
    }
}
