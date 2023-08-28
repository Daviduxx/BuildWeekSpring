package com.epicode.spring.security.payload;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String name;
    private String cognome;
    private String username;
    private String email;
    private String password;
    // Passaggio di ruoli dal client (facoltativo)
    private Set<String> roles;
}

// Dal client mi aspetto un oggetto JSON 
/*
	{
		"name": "Mario",
		"username": "mariolino",
		"email": "m.rossi@example.com",
		"password": "qwerty",
		"secretCode": "12345",
		"creditCard": "1234 5678 9012",
		"roles": ["USER"]
	}
*/
