package com.epicode.spring.security.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicode.spring.security.entity.Fattura;

public interface FatturaPageableRepository extends PagingAndSortingRepository<Fattura, Long>{

}
