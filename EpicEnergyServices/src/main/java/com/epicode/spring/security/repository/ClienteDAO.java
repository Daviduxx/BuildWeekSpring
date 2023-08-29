package com.epicode.spring.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.spring.security.entity.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Long> {

	public boolean existsByPartitaIva(String partitaIva);
	public boolean existsByEmail(String email);
	public boolean existsByPec(String pec);
	public boolean existsByTelefono(String telefono);
	public boolean existsByTelefonoContatto(String telefonoContatto);
	public boolean existsByEmailContatto(String emailContatto);
}
