package com.epicode.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.spring.security.payload.JWTAuthResponse;
import com.epicode.spring.security.payload.LoginDto;
import com.epicode.spring.security.payload.RegisterDto;
import com.epicode.spring.security.payload.RegisterResponse;
import com.epicode.spring.security.service.AuthService;
import com.epicode.spring.security.service.AuthServiceImpl;



@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ees/auth")
public class AuthController {

    private AuthService authService;
    @Autowired private AuthServiceImpl as;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Build Login REST API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
           	
    	String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setUsername(loginDto.getUsername());
        jwtAuthResponse.setAccessToken(token);
        jwtAuthResponse.setRoles(as.getUser(loginDto.getUsername()).getRoles());

        return ResponseEntity.ok(jwtAuthResponse);
    }

    // Build Register REST API
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto){
    	RegisterResponse response = authService.register(registerDto);
        return new ResponseEntity<RegisterResponse>(response, HttpStatus.CREATED);
    }
    
    // JSON inviato dal Client
    /*{
        "name": "Giuseppe",
        "lastname": "Verdi",
        "username": "giuseppevardi",
        "email": "g.verdi@example.com",
        "password": "qwerty",
        "roles": ["MODERATOR", "ADMIN"]
    }*/
}
