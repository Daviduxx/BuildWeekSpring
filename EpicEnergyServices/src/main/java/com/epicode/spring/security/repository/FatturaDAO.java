package com.epicode.spring.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.spring.security.entity.Fattura;

public interface FatturaDAO extends CrudRepository<Fattura, Long> {

}
