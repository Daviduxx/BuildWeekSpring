package com.epicode.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epicode.spring.security.entity.Cliente;
import com.epicode.spring.security.repository.ClienteDAO;
import com.epicode.spring.security.repository.ClientePageableRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {
	@Autowired private ClienteDAO clienteRepo;
	@Autowired private ClientePageableRepository clientePageRepo;
	public Cliente crea(Cliente c) {
		if(clienteRepo.existsByEmail(c.getEmail())) 
			throw new EntityExistsException("Esiste già un cliente con questa mail");
		if(clienteRepo.existsByEmailContatto(c.getEmailContatto()))
			throw new EntityExistsException("Esiste già un cliente con questa mail");
		if(clienteRepo.existsByPartitaIva(c.getPartitaIva()))
			throw new EntityExistsException("Esiste già un cliente con questa PartitaIva");
		if(clienteRepo.existsByPec(c.getPec()))
			throw new EntityExistsException("Esiste già un cliente con questa Pec");
		if(clienteRepo.existsByTelefono(c.getTelefono()))
			throw new EntityExistsException("Esiste già un cliente con questo numero di Telefono");
		if(clienteRepo.existsByTelefonoContatto(c.getTelefonoContatto()))
			throw new EntityExistsException("Esiste già un cliente con questo numero di Telefono");
		return clienteRepo.save(c);
	}
	
	public Cliente getById(long id) {
		if(!clienteRepo.existsById(id))
			throw new EntityNotFoundException("Impossibile trovare il Cliente");
		return clienteRepo.findById(id).get();
	}
	
	public Cliente aggiorna(long id, Cliente c) {
		if(!clienteRepo.existsById(id) || c.getId()!=id)
			throw new EntityNotFoundException("Impossibile trovare il Cliente");
		if(clienteRepo.existsByEmailAndIdNot(c.getEmail(), c.getId())) 
			throw new EntityExistsException("Esiste già un cliente con questa mail");
		if(clienteRepo.existsByEmailContattoAndIdNot(c.getEmailContatto(), c.getId()))
			throw new EntityExistsException("Esiste già un cliente con questa mail");
		if(clienteRepo.existsByPartitaIvaAndIdNot(c.getPartitaIva(), c.getId()))
			throw new EntityExistsException("Esiste già un cliente con questa PartitaIva");
		if(clienteRepo.existsByPecAndIdNot(c.getPec(), c.getId()))
			throw new EntityExistsException("Esiste già un cliente con questa Pec");
		if(clienteRepo.existsByTelefonoAndIdNot(c.getTelefono(), c.getId()))
			throw new EntityExistsException("Esiste già un cliente con questo numero di Telefono");
		if(clienteRepo.existsByTelefonoContattoAndIdNot(c.getTelefonoContatto(), c.getId()))
			throw new EntityExistsException("Esiste già un cliente con questo numero di Telefono");
		
		return clienteRepo.save(c);
	}
	
	public String elimina(long id) {
		if(!clienteRepo.existsById(id))
			throw new EntityNotFoundException("Impossibile trovare il Cliente");
		clienteRepo.deleteById(id);
		return "Cliente eliminato con successo";
	}
	
	public Page<Cliente> getAllContactsPageable(Pageable pageable) {
        return clientePageRepo.findAll(pageable);
    }
}
