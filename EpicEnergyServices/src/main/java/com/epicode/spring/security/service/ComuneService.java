package com.epicode.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.spring.security.entity.Comune;
import com.epicode.spring.security.repository.ComuneDAO;

@Service
public class ComuneService {
	@Autowired private ComuneDAO comuneRepo;
	
	public void crea(Comune c) {
		comuneRepo.save(c);
	}
	
	public Comune getById(long id) {
		return comuneRepo.findById(id).get();
	}
}
