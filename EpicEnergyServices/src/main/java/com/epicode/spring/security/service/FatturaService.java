package com.epicode.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epicode.spring.security.entity.Fattura;
import com.epicode.spring.security.repository.FatturaDAO;
import com.epicode.spring.security.repository.FatturaPageableRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FatturaService {
	@Autowired private FatturaDAO fatturaRepo;
	@Autowired private FatturaPageableRepository fatturaPageRepo;
	public Fattura crea(Fattura f) {
		return fatturaRepo.save(f);
	}
	
	public Fattura getById(long id) {
		if(!fatturaRepo.existsById(id))
			throw new EntityNotFoundException("Impossibile trovare la Fattura");
		return fatturaRepo.findById(id).get();
	}
	
	public Fattura aggiorna(long id, Fattura f) {
		if(fatturaRepo.existsById(id) || f.getId()!=id)
			throw new EntityNotFoundException("Impossibile trovare la Fattura");
		return crea(f);
	}
	
	public String elimina(long id) {
		if(!fatturaRepo.existsById(id))
			throw new EntityNotFoundException("Impossibile trovare la Fattura");
		fatturaRepo.deleteById(id);
		return "Fattura eliminata con successo";
	}
	
	public Page<Fattura> getAllContactsPageable(Pageable pageable) {
        return fatturaPageRepo.findAll(pageable);
    }
}
