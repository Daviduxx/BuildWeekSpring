package com.epicode.spring.security.entity;

import java.time.LocalDate;

import org.springframework.dao.DataIntegrityViolationException;

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
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
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
	
	public void setData(LocalDate data) {
		if(!data.equals(null)) this.data = data;
		else throw new DataIntegrityViolationException("Inserisci una data.");
	}
	public void setImporto(Double importo) {
		if(!importo.equals(null) && importo>0) this.importo = importo;
		else throw new DataIntegrityViolationException("Inserisci un importo corretto.");
	}
	public void setStato(StatoFattura stato) {
		if(!stato.equals(null)) this.stato = stato;
		else throw new DataIntegrityViolationException("Inserisci lo stato.");
	}
	public void setCliente(Cliente cliente) {
		if(!cliente.equals(null)) this.cliente = cliente;
		else throw new DataIntegrityViolationException("Inserisci il cliente.");
	}
}
