package com.example.jpatwodb.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private JWTService jwtService;

    @PostMapping("/auth/gen")
    public ResponseEntity<Map<String, String>> genToken(@Valid @RequestBody AuthRequest request) {
        String token = jwtService.genToken(request);
        Map<String, String> response = Collections.singletonMap("token", token);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/auth/parse")
    public ResponseEntity<Map<String, Object>> parseToken(@RequestBody Map<String, String> request) {
        String token = request.get("token");
        Map<String, Object> response = jwtService.parseToken(token);

        return ResponseEntity.ok(response);
    }

}
