package com.epicode.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.spring.security.entity.Provincia;
import com.epicode.spring.security.repository.ProvinciaDAO;

@Service
public class ProvinciaService {
	@Autowired private ProvinciaDAO provRepo;
	
	public void crea(Provincia p) {
		provRepo.save(p);
	}
	
	public Provincia getByNome(String nome) {
		return provRepo.findByNome(nome);
	}
}
