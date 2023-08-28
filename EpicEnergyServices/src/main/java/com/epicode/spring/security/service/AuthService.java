package com.epicode.spring.security.service;

import com.epicode.spring.security.payload.LoginDto;
import com.epicode.spring.security.payload.RegisterDto;
import com.epicode.spring.security.payload.RegisterResponse;

public interface AuthService {
    
	String login(LoginDto loginDto);
	RegisterResponse register(RegisterDto registerDto);
    
}
