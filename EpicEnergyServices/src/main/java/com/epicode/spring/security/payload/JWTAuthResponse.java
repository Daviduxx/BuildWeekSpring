package com.epicode.spring.security.payload;

import java.util.Set;

import com.epicode.spring.security.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JWTAuthResponse {
	private String username;
	private Set<Role> roles;
    private String accessToken;
    private String tokenType = "Bearer";
}
