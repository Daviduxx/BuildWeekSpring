package com.epicode.spring.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="indirizzi")
public class Indirizzo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String via;
	@Column(nullable = false)
	private Integer civico;
	@Column(nullable = false)
	private String localita;
	@Column(nullable = false)
	private String cap;
	@OneToOne
	private Cliente cliente;
	@ManyToOne
	private Comune comune;
	
	public Indirizzo(String via, Integer civico, String localita, String cap, Cliente cliente, Comune comune) {
		this.via = via;
		this.civico = civico;
		this.localita = localita;
		this.cap = cap;
		this.cliente = cliente;
		this.comune = comune;
	}
}
