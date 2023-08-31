package com.epicode.spring.security.entity;

import org.springframework.dao.DataIntegrityViolationException;

import com.epicode.spring.security.enums.TipoIndirizzo;

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
@Table(name="indirizzi")
public class Indirizzo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoIndirizzo tipoIndirizzo;
	@Column(nullable = false)
	private String via;
	@Column(nullable = false)
	private Integer civico;
	@Column(nullable = false)
	private String localita;
	@Column(nullable = false)
	private String cap;
	@ManyToOne
	private Comune comune;
	
	public void setTipoIndirizzo(TipoIndirizzo tipoIndirizzo) {
		if(!tipoIndirizzo.equals(null)) this.tipoIndirizzo = tipoIndirizzo;
		else throw new DataIntegrityViolationException("Inserisci il tipo di indirizzo.");
	}
	public void setVia(String via) {
		if(!via.equals(null) && via.length()>1) this.via = via;
		else throw new DataIntegrityViolationException("Inserisci una via corretta.");
	}
	public void setCivico(Integer civico) {
		if(!civico.equals(null) && civico>0) this.civico = civico;
		else throw new DataIntegrityViolationException("Inserisci un civico corretto.");
	}
	public void setLocalita(String localita) {
		if(!localita.equals(null) && localita.length()>1) this.localita = localita;
		else throw new DataIntegrityViolationException("Inserisci una località corretta.");
	}
	public void setCap(String cap) {
		if(!cap.equals(null) && cap.length()==5) this.cap = cap;
		else throw new DataIntegrityViolationException("Inserisci un cap corretto.");
	}
	public void setComune(Comune comune) {
		if(!comune.equals(null)) this.comune = comune;
		else throw new DataIntegrityViolationException("Inserisci un comune.");
	}
}
