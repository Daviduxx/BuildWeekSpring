package com.epicode.spring.security.entity;

import java.time.LocalDate;
import java.util.List;

import com.epicode.spring.security.enums.TipoCliente;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Entity
@Setter
@Table(name="clienti")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String ragioneSociale;
	@Column(nullable = false, unique = true)
	private String partitaIva;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private LocalDate dataInserimento;
	private LocalDate dataUltimoContatto;
	@Column(nullable = false)
	private Double fatturatoAnnuale;
	@Column(nullable = false, unique = true)
	private String pec;
	@Column(nullable = false, unique = true)
	private String telefono;
	@Column(nullable = false, unique = true)
	private String emailContatto;
	@Column(nullable = false)
	private String nomeContatto;
	@Column(nullable = false)
	private String cognomeContatto;
	@Column(nullable = false, unique = true)
	private String telefonoContatto;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoCliente tipoCliente;
	@OneToOne(cascade = CascadeType.ALL ,mappedBy = "cliente")
	private Indirizzo sedeLegale;
	@OneToOne(cascade = CascadeType.ALL ,mappedBy = "cliente")
	private Indirizzo sedeOperativa;
	@OneToMany(mappedBy="cliente")
	private List<Fattura> fatture;
	
	public Cliente(String ragioneSociale, String partitaIva, String email, LocalDate dataInserimento,
			LocalDate dataUltimoContatto, Double fatturatoAnnuale, String pec, String telefono, String emailContatto,
			String nomeContatto, String cognomeContatto, String telefonoContatto, TipoCliente tipoCliente,
			Indirizzo sedeLegale, Indirizzo sedeOperativa) {
		super();
		
		this.ragioneSociale = ragioneSociale;
		this.partitaIva = partitaIva;
		this.email = email;
		this.dataInserimento = dataInserimento;
		this.dataUltimoContatto = dataUltimoContatto;
		this.fatturatoAnnuale = fatturatoAnnuale;
		this.pec = pec;
		this.telefono = telefono;
		this.emailContatto = emailContatto;
		this.nomeContatto = nomeContatto;
		this.cognomeContatto = cognomeContatto;
		this.telefonoContatto = telefonoContatto;
		this.tipoCliente = tipoCliente;
		this.sedeLegale = sedeLegale;
		this.sedeOperativa = sedeOperativa;
	}
	
}
