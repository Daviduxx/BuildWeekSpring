package com.epicode.spring.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Entity
@Setter
@Table(name="province")
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String sigla;
	@Column(nullable = false, unique = true)
	private String nome;
	@Column(nullable = false)
	private String regione;
	
	public Provincia(String sigla, String nome, String regione) {
		super();
		this.sigla = sigla;
		this.nome = nome;
		this.regione = regione;
	}
}
