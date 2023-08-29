package com.epicode.spring.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.spring.security.entity.Provincia;


public interface ProvinciaDAO extends CrudRepository<Provincia, Long>{
	public Provincia findByNome(String nome);
}
