package com.epicode.spring.security.entity;

import java.time.LocalDate;

import com.epicode.spring.security.enums.StatoFattura;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Setter
@Table(name="fatture")
public class Fattura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private LocalDate data;
	@Column(nullable = false)
	private Double importo;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StatoFattura stato;
	@ManyToOne
	private Cliente cliente;
}
