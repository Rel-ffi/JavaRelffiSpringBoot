package org.springrelffi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springrelffi.models.Role;
import org.springrelffi.services.UserService;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")

    public ResponseEntity<String> login(@RequestBody Map<String,String> request) {
        String username = request.get("username");
        String password = request.get("password");

        String token = userService.login(username, password);

        return ResponseEntity.ok("Token: " + token);
    }


    @PostMapping("/register")
    public ResponseEntity<String> register (@RequestBody Map<String,String> request) {
        String username = request.get("username");
        String password = request.get("password");
        Role role = Role.valueOf(
                "ROLE_" + request.getOrDefault("role", "USER")
                        .toUpperCase()
        );

        String token = userService.register(username,password, role);

        return ResponseEntity.ok().body("Token: " + token);
    }
}
