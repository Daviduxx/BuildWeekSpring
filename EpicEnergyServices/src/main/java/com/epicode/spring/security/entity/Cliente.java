package com.epicode.spring.security.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

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
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name="clienti")
public class Cliente {
	@Transient
	private String emailRegEx="^[a-z0-9]{3,15}@[a-z]{2,7}\\.[a-z]{2,5}$";
	
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
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente")
	private Indirizzo sedeLegale;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente")
	private Indirizzo sedeOperativa;
	@OneToMany(mappedBy="cliente")
	private List<Fattura> fatture;
	
	public Cliente(String ragioneSociale, String partitaIva, String email, LocalDate dataInserimento,
			LocalDate dataUltimoContatto, Double fatturatoAnnuale, String pec, String telefono, String emailContatto,
			String nomeContatto, String cognomeContatto, String telefonoContatto, TipoCliente tipoCliente,
			Indirizzo sedeLegale, Indirizzo sedeOperativa) {
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

	public void setRagioneSociale(String ragioneSociale) {
		if(!ragioneSociale.equals(null) && ragioneSociale.length()>1) this.ragioneSociale = ragioneSociale;
		else throw new DataIntegrityViolationException("Inserisci una ragione sociale corretta.");
	}

	public void setPartitaIva(String partitaIva) {
		if(!partitaIva.equals(null) && partitaIva.length()==11) this.partitaIva = partitaIva;
		else throw new DataIntegrityViolationException("Inserisci una partita iva corretta.");
	}

	public void setEmail(String email) {
		if(!email.equals(null) && email.matches(emailRegEx)) this.email = email;
		else throw new DataIntegrityViolationException("Inserisci un'email corretta.");
	}

	public void setDataInserimento(LocalDate dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public void setDataUltimoContatto(LocalDate dataUltimoContatto) {
		this.dataUltimoContatto = dataUltimoContatto;
	}

	public void setFatturatoAnnuale(Double fatturatoAnnuale) {
		if(!fatturatoAnnuale.equals(null) && fatturatoAnnuale>0) this.fatturatoAnnuale = fatturatoAnnuale;
		else throw new DataIntegrityViolationException("Inserisci un fatturato corretto.");
	}

	public void setPec(String pec) {
		if(!pec.equals(null) && pec.matches(emailRegEx)) this.pec = pec;
		else throw new DataIntegrityViolationException("Inserisci una pec corretta.");
	}

	public void setTelefono(String telefono) {
		if(!telefono.equals(null) && telefono.length()<=9) this.telefono = telefono;
		else throw new DataIntegrityViolationException("Inserisci un numero di telefono corretto.");
	}

	public void setEmailContatto(String emailContatto) {
		if(!emailContatto.equals(null) && emailContatto.matches(emailRegEx)) this.emailContatto = emailContatto;
		else throw new DataIntegrityViolationException("Inserisci un'email corretta.");
	}

	public void setNomeContatto(String nomeContatto) {
		if(!nomeContatto.equals(null) && nomeContatto.length()>1) this.nomeContatto = nomeContatto;
		else throw new DataIntegrityViolationException("Inserisci un nome corretto.");
	}

	public void setCognomeContatto(String cognomeContatto) {
		if(!cognomeContatto.equals(null) && cognomeContatto.length()>1) this.cognomeContatto = cognomeContatto;
		else throw new DataIntegrityViolationException("Inserisci un cognome corretto.");
	}

	public void setTelefonoContatto(String telefonoContatto) {
		if(!telefonoContatto.equals(null) && telefonoContatto.length()<=9) this.telefonoContatto = telefonoContatto;
		else throw new DataIntegrityViolationException("Inserisci un numero di telefono corretto.");
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		if(!tipoCliente.equals(null)) this.tipoCliente = tipoCliente;
		else throw new DataIntegrityViolationException("Specificare la tipologia di azienda.");
	}

	public void setSedeLegale(Indirizzo sedeLegale) {
		if(!sedeLegale.equals(null)) this.sedeLegale = sedeLegale;
		else throw new DataIntegrityViolationException("Specificare l'indirizzo della sede legale.");
	}

	public void setSedeOperativa(Indirizzo sedeOperativa) {
		if(!sedeOperativa.equals(null)) this.sedeOperativa = sedeOperativa;
		else throw new DataIntegrityViolationException("Specificare l'indirizzo della sede operativa.");
	}

	public void setFatture(List<Fattura> fatture) {
		this.fatture = fatture;
	}
	
}
