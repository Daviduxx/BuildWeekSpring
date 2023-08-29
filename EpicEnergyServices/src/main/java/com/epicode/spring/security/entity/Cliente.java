package com.epicode.spring.security.entity;

import java.time.LocalDate;
import java.util.List;

import com.epicode.spring.security.enums.TipoCliente;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
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
	@OneToOne(mappedBy = "cliente")
	private Indirizzo sedeLegale;
	@OneToOne(mappedBy = "cliente")
	private Indirizzo sedeOperativa;
	@OneToMany(mappedBy="cliente")
	private List<Fattura> fatture;
}
