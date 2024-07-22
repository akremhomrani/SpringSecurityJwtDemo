package tn.homrnai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.homrnai.dto.AuthenticationRequest;
import tn.homrnai.dto.AuthenticationResponse;
import tn.homrnai.dto.RegisterRequest;
import tn.homrnai.service.AuthService;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {
    @Autowired
    private  AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRequest
    ) {
        AuthenticationResponse authResponse = authService.register(registerRequest);
        return  ResponseEntity.ok(authResponse);
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

}
